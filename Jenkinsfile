
def ARTEFACTORY = [
  SPRINT_NUMBER : "25",
  APP : "android",
  NAME_FUNCTIONALITY : "",
  PUBLISH_ARTEFACTORY : 1,
  RUTA_ARTEFACTORY:"",

]
def server = Artifactory.server 'artefactoryID'


node (){//"casa"

        try{

                stage("GET SOURCE"){
                    checkout scm
                }


                 //   if (env.BRANCH_NAME != "develop" || env.BRANCH_NAME != "master") {
                      stage("ANALYZE SONARQUBE"){
                         withSonarQubeEnv("SonarServidor") {
                            //v1
                           //  bat("gradlew clean assembleCorporateDebug lintCorporateDebug jacocoTestDevelopDebugUnitTestReport --info sonarqube")

                               bat("gradlew assembleCorporateDebug lintCorporateDebug --info sonarqube -PHOST_SONAR=${env.SONAR_HOST_URL}")
                             // con prueba emulator
                           //  bat ("gradlew clean createCorporateDebugCoverageReport jacocoTestReport --info sonarqube")

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
                   //}


                  stage("BUILD ARTEFACTORY"){
                       bat ("gradlew clean assembleCorporateDebug")
                  }

                 stage ("PUBLISH ARTEFACTORY"){

                   ARTEFACTORY.RUTA_ARTEFACTORY = "Artefactory_IBK/sprint-${ARTEFACTORY.SPRINT_NUMBER}/${ARTEFACTORY.APP}/${env.BRANCH_NAME}/"

                   def uploadSpec = """{"files": [{"pattern": "**/*corporate*.apk",  "target": "${ARTEFACTORY.RUTA_ARTEFACTORY}" }] }"""


                  if(ARTEFACTORY.PUBLISH_ARTEFACTORY==1){
                       def buildInfo2 =  server.upload(uploadSpec)
                       server.publishBuildInfo(buildInfo2)
                  }
               }

               stage("SEND EMAIL OK"){
                       def files = findFiles(glob: '**/*.apk')
                       enviarMailOK("PATH : ${ARTEFACTORY.RUTA_ARTEFACTORY}","apk <b>: ${server.url}/${ARTEFACTORY.RUTA_ARTEFACTORY}/"+getNameFile(files) +"<b>")
               }

         }catch(Exception e){
                   stage("SEND EMAIL ERROR"){
                        enviarMailError( )
                    }
                    throw e
            }
}




def getNameFile(list) {
    def name = ""
      for(int i = 0; i < list.size(); i++) {
          name = list[i].name
      }
    return name
}


def enviarMailOK(  subject,   body){
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
