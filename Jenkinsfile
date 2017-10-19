/*
 @author: edgard espinoza
 @description:
*/


def ARTEFACTORY = [
  SPRINT_NUMBER : "",         //numero de la version
  APP : "android",              //si es android o ios
  PUBLISH_ARTEFACTORY : 1,
  UNIT_TEST : 1,
  RUTA_ARTEFACTORY:"",
  BUILD_FLAVOR:"Corporate",   //define el flavor de compilacion |DeployStore|Corporate
 // ETIQUETA_SLAVE:"",  //"casa" //etiqueta del slave jenkins si es vacio se compila en el master,
  NAME_FILE_ARTEFACTORY:""
]

def server = Artifactory.server 'artefactoryID'


node (){//casa

        try{

                stage("GET SOURCE"){
                    checkout scm
                }

                stage("PROCESS SOURCE"){
                    bat ("xcopy /s %IBK_HOME%\* /Y")
                    bat ("javac ReplaceFile.java")
                    bat ("java ReplaceFile")
                }


                if (  env.BRANCH_NAME != "master" && ARTEFACTORY.UNIT_TEST == 1 ) {
                      stage("ANALYZE SONARQUBE"){
                          withSonarQubeEnv("SonarServidor") {
                                //v1
                               //  bat("gradlew clean assemble${ARTEFACTORY.BUILD_FLAVOR}Debug lint${ARTEFACTORY.BUILD_FLAVOR}Debug jacocoTestDevelopDebugUnitTestReport --info sonarqube")

                                   bat("gradlew clean assemble${ARTEFACTORY.BUILD_FLAVOR}Debug lint${ARTEFACTORY.BUILD_FLAVOR}Debug --info sonarqube -PHOST_SONAR=${env.SONAR_HOST_URL}")
                                 // con prueba emulator
                               //  bat ("gradlew clean create${ARTEFACTORY.BUILD_FLAVOR}DebugCoverageReport jacocoTestReport --info sonarqube")

                              }
                      }


                       stage("Quality Gate"){
                         timeout(time: 1, unit: 'HOURS') {
                             def qg = waitForQualityGate()
                             if (qg.status != 'OK') {
                                 enviarMailError( )
                                 error "Pipeline aborted due to quality gate failure: ${qg.status}"
                             }
                         }
                       }
                }


                  stage("BUILD ARTEFACTORY"){
                       bat ("gradlew clean assemble${ARTEFACTORY.BUILD_FLAVOR}Debug")
                  }



                  stage("PROCESS ARTEFACTORY"){

                           def files = findFiles(glob: '**/*.apk')

                           ARTEFACTORY.NAME_FILE_ARTEFACTORY =  getNameFile(files)

                           ARTEFACTORY.SPRINT_NUMBER = getSprintNumber(ARTEFACTORY.NAME_FILE_ARTEFACTORY)

                   }

                  stage ("PUBLISH ARTEFACTORY"){

                   ARTEFACTORY.RUTA_ARTEFACTORY = "Artefactory_IBK/sprint-${ARTEFACTORY.SPRINT_NUMBER}/${ARTEFACTORY.APP}/${env.BRANCH_NAME}/"

                   def uploadSpec = """{"files": [{"pattern": "**/*${ARTEFACTORY.BUILD_FLAVOR.toLowerCase()}*.apk",  "target": "${ARTEFACTORY.RUTA_ARTEFACTORY}" }] }"""


                  if( ARTEFACTORY.PUBLISH_ARTEFACTORY == 1 ){
                       def buildInfo2 =  server.upload(uploadSpec)
                       server.publishBuildInfo(buildInfo2)
                  }
               }

               stage("SEND EMAIL OK"){

                       enviarMailOK("PATH : ${ARTEFACTORY.RUTA_ARTEFACTORY}","apk <b>: ${server.url}/${ARTEFACTORY.RUTA_ARTEFACTORY}/${ARTEFACTORY.NAME_FILE_ARTEFACTORY}<b>")
               }

         }catch(Exception e){
                   stage("SEND EMAIL ERROR"){
                        enviarMailError( )
                    }
                    throw e
            }
}



@NonCPS
def getSprintNumber(nameArtefactory){

    def s = nameArtefactory =~ /SP(.*)v/

    while (s.find())  return s.group(1)

}

def getNameFile(list) {
    def name = ""
      for(int i = 0; i < list.size(); i++) {
          name = list[i].name
      }
    return name
}


def enviarMailOK( subject,   body){
    enviarMail("EnvioCorreo - Ejecucion Exitosa   ${subject} ", "Ejecucion exitosa  <BR> ${body}")
}

def enviarMailError( ){
    enviarMail("EnvioCorreo - Error al ejecutar ", "Error al ejecutar por favor revisar <br> ${env.BUILD_URL}")
}

def enviarMail(subject, body){
    def date = new Date().format( 'dd/MM/yyyy HH:mm:ss' )
    def BODY_MAIL = "${body} <br> a las ${date} <br><br><br> Por favor no replicar este correo."
    def DEFAULT_RECIPIENTS="eespinor@everis.com"

    mail( body: "${BODY_MAIL}",
          from: "everisdemo123@gmail.com",
          subject: "${subject}  ${date}",
          mimeType: 'text/html',
          to:  "${DEFAULT_RECIPIENTS}"
    )
}
