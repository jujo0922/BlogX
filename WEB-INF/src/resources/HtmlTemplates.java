package resources;

public class HtmlTemplates {

  public static String html() {

    String web = """
        <!DOCTYPE html>
        <html lang='es'>
        <head>
        <meta charset='UTF-8'>
        <meta http-equiv='X-UA-Compatible'content='IE=edge'>
        <meta name='viewport' content='width=device-width, initial-scale=1.0'>
        <title>Installer</title>
        <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>
        <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p' crossorigin='anonymous'></script>
        <link rel='stylesheet' href='web_resources/css/global.css'>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css'/>
        <link rel='stylesheet' href='$css_route$'>
        </head>
        $web_code$
        </html>
        """;

    return web;
  }

  public static String flexBoddy() {

    String htnml = """
        <body class='d-flex justify-content-center align-items-center'>
        $web_code$
        </body>
        """;

    return htnml;
  }

  public static String installerDBPage() {
    String htnml = """
        <!DOCTYPE html>
        <html lang='es'>
        <head>
        <meta charset='UTF-8'>
        <meta http-equiv='X-UA-Compatible'content='IE=edge'>
        <meta name='viewport' content='width=device-width, initial-scale=1.0'>
        <title>$blog_name$ | Installer</title>
        <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>
        <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p' crossorigin='anonymous'></script>
        <link rel='stylesheet' href='web_resources/css/global.css'>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css'/>
        <link rel='stylesheet' href='web_resources/css/installer/installerDB.css'>
        <meta http-equiv='refresh' content='5; url=http://localhost:8080/WebBlog/$status_page$'/>
        </head>
        <body class='d-flex justify-content-center align-items-center text-center'>

        <p class='title animate__animated animate__fadeIn animate__slow'>Instalando...</p>

        <img class='imgInstaller animate__animated animate__fadeIn animate__slow featuredImage' src='web_resources/images/installer/setupDB.svg' alt=''>

        <div class='spinner-border spinner' role='status'>
        </div>
        <br>
        <p class=' animate__animated animate__fadeIn animate__slow'>Se te avisar&#225 cuando puedas cerrar esta ventana.</p>
        <p class=' animate__animated animate__fadeIn animate__slow'>Gracias por usar BlogX.</p>

        </body>
        </html>
        """;

    return htnml;
  }

  public static String homePage() {
    String htnml = """
                        <!DOCTYPE html>
                        <html lang='es'>
                        <head>
                        <meta charset='UTF-8'>
                        <meta http-equiv='X-UA-Compatible'content='IE=edge'>
                        <meta name='viewport' content='width=device-width, initial-scale=1.0'>
                        <title>$blog_name$ | Home</title>
                        <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>
                        <link rel='stylesheet' href='web_resources/css/global.css'>
                        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css'/>
                        <link rel='stylesheet' href='web_resources/css/home/home.css'>
                         <link rel='icon' type='image/x-icon' href='./web_resources/images/favicon.svg'>
                        </head>
                        <body>

                            <nav class='navbar navbar-expand-lg blogx-primaryColor navBarShadow'>
                                <div class='container-fluid'>
                                  <a class='navbar-brand blogx-textPrimaryColor hover' href='WebBlog/home'>$blog_name$</a>
                                  <button class='navbar-toggler' type='button' data-bs-toggle='collapse' data-bs-target='#navbarSupportedContent' aria-controls='navbarSupportedContent' aria-expanded='false' aria-label='Toggle navigation'>
                                    <span class='navbar-toggler-icon'></span>
                                  </button>
                                  <div class='collapse navbar-collapse' id='navbarSupportedContent'>
                                    <ul class='navbar-nav me-auto mb-2 mb-lg-0'>
                                      <li class='nav-item'>
                                        <a class='nav-link active blogx-textPrimaryColor hover' aria-current='page' href='/WebBlog/home'>Home</a>
                                      </li>
                                      $control_panel_nav$
                                    </ul>
                                    $session_status$
                                  </div>
                                </div>
                            </nav>

                            <main class='container' style='background: white; box-shadow: 0px 0px 10px 2px rgba(0, 0, 0, 0.486); border-radius: 10px; padding: 10px;'>
                            <h1 style='margin-top: 20px; margin-bottom: 20px;' class='text-center'>&#218ltimo Blog</h1>
                              <a href='/WebBlog/entry?id=$id_entry$'>
                                <div class='card bg-dark text-white featuredEntry'>
                                  <img width='100%'' height='100%' src='$entry_image$' class='card-img' alt='error'>
                                  <div class='card-img-overlay'>
                                     <h5 class='card-title'>$card_title$</h5>
                                      <p class='card-text'>Publicado el $entry_date$</p>
                                  </div>
                                </div>
                              </a>
                              <div style='margin-top: 20px;' class='row'>
                                <h2 style='margin-top: 20px; margin-bottom: 20px;' class='text-center'>Conoce m&#225s de nuestro blog</h2>
                                $all_entrys$
                              </div>
                            </main>
                            <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p' crossorigin='anonymous'></script>
                        </body>
                        </html>
                        <style>
        :root {
          --primaryColor: $primary_color$;
          --secondaryColor: $secondary_color$;
          --textPrimaryColor: $text_primary_color$;
          --textSecondaryColor: $text_secondary_color$;
        }

        .navBarShadow{
          box-shadow: 0 4px 10px -2px #000000;
        }

        body {
          background-image: url($blog_background$);
          background-position: center;
          background-repeat: no-repeat;
          background-size: cover;
          height: 100vh;
          width: 100%;
        }

        .blogx-primaryColor{
            background-color: var(--primaryColor);
        }

        .hover:hover{
          text-decoration: underline ;
          color: var(--secondaryColor);
        }

        .blogx-secondaryColor{
            background-color:  var(--secondaryColor);
        }

        .blogx-textPrimaryColor{
            color: var(--textPrimaryColor);
        }
        .blogx-textSecondaryColor{
            color: var(--textSecondaryColor);
        }

        .featuredEntry {
          height: 700px;
        }

        .btn-login{
          margin-right: 20px;
          border: none;
          padding: 7px;
          border-radius: 5px;
        }

        .entryImage {
          max-height: 190px;
        }

        .hoverPrimaryColor:hover {
          text-decoration: underline;
          color: var(--primaryColor) !important;
        }

        .noTextDecoration{
          text-decoration: none !important;
        }

        </style>
                                """;

    return htnml;
  }

  public static String loginErrorPage() {
    String htnml = """
                                <!DOCTYPE html>
                                <html lang='es'>
                                <head>
                                <meta charset='UTF-8'>
                                <meta http-equiv='X-UA-Compatible'content='IE=edge'>
                                <meta name='viewport' content='width=device-width, initial-scale=1.0'>
                                <title>$blog_name$ | Login</title>
                                <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>
                                <link rel='stylesheet' href='web_resources/css/global.css'>
                                <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css'/>
                                <link rel='stylesheet' href='web_resources/css/home/home.css'>
                                <link rel='icon' type='image/x-icon' href='./web_resources/images/favicon.svg'>
                                </head>
                                <body>

                                <nav class='navbar navbar-expand-lg blogx-primaryColor navBarShadow'>
                                <div class='container-fluid'>
                                  <a class='navbar-brand blogx-textPrimaryColor hover' href='/WebBlog/home'>$blog_name$</a>
                                  <button class='navbar-toggler' type='button' data-bs-toggle='collapse' data-bs-target='#navbarSupportedContent'
                                    aria-controls='navbarSupportedContent' aria-expanded='false' aria-label='Toggle navigation'>
                                    <span class='navbar-toggler-icon'></span>
                                  </button>
                                  <div class='collapse navbar-collapse' id='navbarSupportedContent'>
                                    <ul class='navbar-nav me-auto mb-2 mb-lg-0'>
                                      <li class='nav-item'>
                                        <a class='nav-link active blogx-textPrimaryColor hover' aria-current='page' href='/WebBlog/home'>Inicio</a>
                                      </li>
                                    </ul>

                                  </div>
                                </div>
                              </nav>

                              <main class='d-flex justify-content-center align-items-center'>
                                <div class='panel d-flex justify-content-center align-items-center'>
                                  <h3 class='animate__animated animate__fadeIn animate__slow'>Error al iniciar sesi&#243n.</h3>
                                  <img class='animate__animated animate__fadeIn animate__slow' src='./web_resources/images/login/loginError.svg' alt='error'><br><br>
                                  <a href='/WebBlog/login'><button class='btnSubmit animate__animated animate__fadeIn animate__slow' >Volver a iniciar sesi&#243n</button></a>

                                </div>
                              </main>
                                    <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p' crossorigin='anonymous'></script>
                                </body>
                                </html>
                                <style>
                                :root {
                                  --primaryColor: $primary_color$;
                                  --secondaryColor: $secondary_color$;
                                  --textPrimaryColor: $text_primary_color$;
                                  --textSecondaryColor: $text_secondary_color$;
                                }

          .panel {
            background-repeat: no-repeat;
            background-position: center;
            background-size: 450px;
            background-color: #EDF2F4;
            height: 550px;
            width: 500px;
            border-radius: 10px;
            flex-direction: column;
            margin-top: 100px;
            box-shadow: 0px 0px 10px 2px rgba(0, 0, 0, 0.486);
          }
          .navBarShadow{
            box-shadow: 0 4px 10px -2px #000000;
          }
          .inpUser{
            margin-left: 30px;
          }

          .btnSubmit {
            border-radius: 10px;
            padding: 5px;
            background-color: #f2007a;
            border: none;
            transition: 0.2s;
            color: white;
          }

          .btnSubmit:hover {
            transform: scale(1.1);
          }

          .panel img {
            width: 200px;
          }

          .blogx-primaryColor {
            background-color: var(--primaryColor);
          }

          body {
            background-image: url($blog_background$);
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            height: 100vh;
            width: 100%;
          }

          .hover:hover {
            text-decoration: underline;
            color: var(--secondaryColor);
          }

          .hoverPrimaryColor:hover {
            text-decoration: underline;
            color: var(--primaryColor) !important;
          }

          .noTextDecoration {
            text-decoration: none !important;
          }

          .blogx-secondaryColor {
            background-color: var(--secondaryColor);
          }

          .blogx-textPrimaryColor {
            color: var(--textPrimaryColor);
          }

          .blogx-textSecondaryColor {
            color: var(--textSecondaryColor);
          }

          .btn-login {
            margin-right: 20px;
            border: none;
            padding: 7px;
            border-radius: 5px;
          }
        </style>
                                        """;

    return htnml;
  }

  public static String LoginPage() {
    String html = """
        <!DOCTYPE html>
        <html lang='es'>

        <head>
          <meta charset='UTF-8'>
          <meta http-equiv='X-UA-Compatible' content='IE=edge'>
          <meta name='viewport' content='width=device-width, initial-scale=1.0'>
          <title>$blog_name$ | Login</title>
          <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet'
            integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>
          <link rel='stylesheet' href='web_resources/css/global.css'>
          <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css' />
          <link rel='stylesheet' href='web_resources/css/home/home.css'>
          <link rel='icon' type='image/x-icon' href='./web_resources/images/favicon.svg'>
        </head>

        <body>

          <main class='d-flex justify-content-center align-items-center'>
            <div class='panel d-flex justify-content-center align-items-center' style='box-shadow: 0px 0px 10px 2px rgba(0, 0, 0, 0.486);'>
              <h3 class='animate__animated animate__fadeIn animate__slow'>Iniciar sesi&#243n.</h3>
              <img class='animate__animated animate__fadeIn animate__slow' src='./web_resources/images/login/login.svg' alt=''><br><br>
              <form action='/WebBlog/loginCheck' method='post'>
                <label class='animate__animated animate__fadeIn animate__slow' for='user'>Usuario:</label>
                <input class='inpUser animate__animated animate__fadeIn animate__slow' type='text' name='user' required><br><br>
                <label class='animate__animated animate__fadeIn animate__slow' for='user'>Contrase&#241a:</label>
                <input class='animate__animated animate__fadeIn animate__slow' type='password' name='password' required><br><br>
                <input class='btnSubmit animate__animated animate__fadeIn animate__slow' type='submit' value='Inciar Sesi&#243n.'>

              </form>

            </div>
          </main>

          <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js'
            integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p'
            crossorigin='anonymous'></script>
        </body>

        </html>
        <style>
        :root {
          --primaryColor: $primary_color$;
          --secondaryColor: $secondary_color$;
          --textPrimaryColor: $text_primary_color$;
          --textSecondaryColor: $text_secondary_color$;
        }

          .panel {
            background-repeat: no-repeat;
            background-position: center;
            background-size: 450px;
            background-color: #EDF2F4;
            height: 550px;
            width: 500px;
            border-radius: 10px;
            flex-direction: column;
            margin-top: 100px;
          }
          .inpUser{
            margin-left: 30px;
          }

          .btnSubmit {
            border-radius: 10px;
            padding: 5px;
            background-color: var(--primaryColor);
            border: none;
            transition: 0.2s;
            color: white;
            margin-left: 90px;
          }

          .btnSubmit:hover {
            transform: scale(1.1);
          }

          .panel img {
            width: 400px;
          }

          .blogx-primaryColor {
            background-color: var(--primaryColor);
          }

          body {
            background-image: url($blog_background$);
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            height: 100vh;
            width: 100%;
          }

          .hover:hover {
            text-decoration: underline;
            color: var(--secondaryColor);
          }

          .hoverPrimaryColor:hover {
            text-decoration: underline;
            color: var(--primaryColor) !important;
          }

          .noTextDecoration {
            text-decoration: none !important;
          }

          .blogx-secondaryColor {
            background-color: var(--secondaryColor);
          }

          .blogx-textPrimaryColor {
            color: var(--textPrimaryColor);
          }

          .blogx-textSecondaryColor {
            color: var(--textSecondaryColor);
          }

          .btn-login {
            margin-right: 20px;
            border: none;
            padding: 7px;
            border-radius: 5px;
          }
        </style>


        """;

    return html;

  }

  public static String controlPanelPage() {

    String html = """
            <!DOCTYPE html>
            <html lang='es'>

            <head>
              <meta charset='UTF-8'>
              <meta http-equiv='X-UA-Compatible' content='IE=edge'>
              <meta name='viewport' content='width=device-width, initial-scale=1.0'>
              <title>$blog_name$ | Control Panel</title>
              <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet'
                integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>
              <link rel='stylesheet' href='web_resources/css/global.css'>
              <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css' />
              <link rel='stylesheet' href='web_resources/css/home/home.css'>
              <link rel='icon' type='image/x-icon' href='./web_resources/images/favicon.svg'>
            </head>

            <body>

            <nav class='navbar navbar-expand-lg blogx-primaryColor'>
            <div class='container-fluid'>
              <a class='navbar-brand blogx-textPrimaryColor hover' href='/WebBlog/home'>$blog_name$</a>
              <button class='navbar-toggler' type='button' data-bs-toggle='collapse' data-bs-target='#navbarSupportedContent' aria-controls='navbarSupportedContent' aria-expanded='false' aria-label='Toggle navigation'>
                <span class='navbar-toggler-icon'></span>
              </button>
              <div class='collapse navbar-collapse' id='navbarSupportedContent'>
                <ul class='navbar-nav me-auto mb-2 mb-lg-0'>
                  <li class='nav-item'>
                    <a class='nav-link active blogx-textPrimaryColor hover' aria-current='page' href='/WebBlog/home'>Home</a>
                  </li>
                  $control_panel_nav$
                </ul>
                $session_status$
              </div>
            </div>
        </nav>

              <nav class='navbar navbar-expand-lg navbar-light bg-light navBarShadow' style='bottom: 0px !important;'>
                <button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarNav'
                  aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>
                  <span class='navbar-toggler-icon'></span>
                </button>
                <div class='collapse navbar-collapse' id='navbarNav'>
                  <ul class='navbar-nav'>
                    <li class='nav-item active'>
                      <button style='margin-left: 20px;' type='button' class='btn blogx-primaryColor blogx-textPrimaryColor' id='entrys'>Administrar Entradas</button>
                    </li>
                    <li class='nav-item'>
                      <button style='margin-left: 20px;' type='button' class='btn blogx-primaryColor blogx-textPrimaryColor'  id='users'>Administrar Usuarios</button>
                    </li>
                    <li class='nav-item'>
                      <button style='margin-left: 20px;' type='button' class='btn blogx-primaryColor blogx-textPrimaryColor' id='settings'>Administrar Apariencia</button>
                    </li>
                  </ul>
                </div>
              </nav>

              <main class='d-flex justify-content-center align-items-center'>
                <iframe class='panel' id='iframe' src='/WebBlog/ControlPanelEntrys' frameborder='0' style='box-shadow: 0px 0px 10px 2px rgba(0, 0, 0, 0.486);'></iframe>
              </main>

              <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js'
                integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p'
                crossorigin='anonymous'></script><script type='text/javascript'>
                  function changeSrcIframe(newSrc) {
                    var iframe = document.getElementById('iframe')
                    iframe.src = newSrc;
                  }

                  function cahngeToEntrys(){
                    changeSrcIframe('/WebBlog/ControlPanelEntrys')
                  }

                  function changeToUsers(){
                    changeSrcIframe('/WebBlog/ControlPanelUsers');
                  }

                  function changeToSettings(){
                    changeSrcIframe('/WebBlog/ControlPanelEditTheme');
                  }

                  function load() {
                    var entrys = document.getElementById('entrys');
                    var users = document.getElementById('users');
                    var settings = document.getElementById('settings');
                    entrys.addEventListener('click', cahngeToEntrys, false);
                    users.addEventListener('click', changeToUsers, false);
                    settings.addEventListener('click', changeToSettings, false);
                  }

                  document.addEventListener('DOMContentLoaded', load, false);
                </script>
            </body>

            </html>

            <style>
            :root {
              --primaryColor: $primary_color$;
              --secondaryColor: $secondary_color$;
              --textPrimaryColor: $text_primary_color$;
              --textSecondaryColor: $text_secondary_color$;
            }

            .navBarShadow{
              box-shadow: 0 4px 10px -2px #000000;
            }

              .panel {
                background-repeat: no-repeat;
                background-position: center;
                background-size: 450px;
                background-color: #EDF2F4;
                height: 700px;
                width: 50%;
                border-radius: 10px;
                flex-direction: column;
                margin-top: 40px;
              }

              .inpUser {
                margin-left: 30px;
              }

              .btnSubmit {
                border-radius: 10px;
                padding: 5px;
                background-color: #f2007a;
                border: none;
                transition: 0.2s;
                color: white;
              }

              .btnSubmit:hover {
                transform: scale(1.1);
              }

              .panel img {
                width: 200px;
              }

              .blogx-primaryColor {
                background-color: var(--primaryColor);
              }

              body {
                background-image: url($blog_background$);
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
                height: 100vh;
                width: 100%;
              }

              .hover:hover {
                text-decoration: underline;
                color: var(--secondaryColor);
              }

              .hoverPrimaryColor:hover {
                text-decoration: underline;
                color: var(--primaryColor) !important;
              }

              .noTextDecoration {
                text-decoration: none !important;
              }

              .blogx-secondaryColor {
                background-color: var(--secondaryColor);
              }

              .blogx-textPrimaryColor {
                color: var(--textPrimaryColor);
              }

              .blogx-textSecondaryColor {
                color: var(--textSecondaryColor);
              }

              .btn-login {
                margin-right: 20px;
                border: none;
                padding: 7px;
                border-radius: 5px;
              }
            </style>

            """;

    return html;

  }

  public static String entryPage() {

    String html = """
            <!DOCTYPE html>
            <html lang='es'>

            <head>
              <meta charset='UTF-8'>
              <meta http-equiv='X-UA-Compatible' content='IE=edge'>
              <meta name='viewport' content='width=device-width, initial-scale=1.0'>
              <title>$blog_name$ | Entrada Blog</title>
              <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet'
                integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>
              <link rel='stylesheet' href='web_resources/css/global.css'>
              <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css' />
              <link rel='stylesheet' href='web_resources/css/home/home.css'>
              <link rel='icon' type='image/x-icon' href='./web_resources/images/favicon.svg'>
            </head>

            <body>

            <nav class='navbar navbar-expand-lg blogx-primaryColor navBarShadow'>
            <div class='container-fluid'>
              <a class='navbar-brand blogx-textPrimaryColor hover' href='/WebBlog/home'>$blog_name$</a>
              <button class='navbar-toggler' type='button' data-bs-toggle='collapse' data-bs-target='#navbarSupportedContent' aria-controls='navbarSupportedContent' aria-expanded='false' aria-label='Toggle navigation'>
                <span class='navbar-toggler-icon'></span>
              </button>
              <div class='collapse navbar-collapse' id='navbarSupportedContent'>
                <ul class='navbar-nav me-auto mb-2 mb-lg-0'>
                  <li class='nav-item'>
                    <a class='nav-link active blogx-textPrimaryColor hover' aria-current='page' href='/WebBlog/home'>Home</a>
                  </li>
                  $control_panel_nav$
                </ul>
                $session_status$
              </div>
            </div>
        </nav>

              <main class='d-flex justify-content-center align-items-center'>
              <div class='panel'>
                <img class='' src=$entry_image$ alt='error'>
                <h1 class='text-center'>$entry_title$</h1>
                <h6 class='text-center'>Publicado el: $entry_date$</h6>
                <p style='word-wrap: break-word'>$entry_body$</p>
              </div>
            </main>
            </body>

            </html>

            <style>
            :root {
              --primaryColor: $primary_color$;
              --secondaryColor: $secondary_color$;
              --textPrimaryColor: $text_primary_color$;
              --textSecondaryColor: $text_secondary_color$;
            }

            .navBarShadow{
              box-shadow: 0 4px 10px -2px #000000;
            }

            .panel {
              background-color: #EDF2F4;
              min-height: 700px;
              width: 900px;
              border-radius: 10px;
              flex-direction: column;
              margin-top: 40px;
              box-shadow: 0px 0px 10px 2px rgba(0, 0, 0, 0.486);
            }
            .panel h1{
              margin-top: 20px;
              text-decoration: underline var(--primaryColor);
            }

            .panel img {
              width: 900px;
              border-top-left-radius: 10px;
              border-top-right-radius: 10px;
              border-top-left-radius: 10px;
              height: 500px;
              border-bottom: 2px solid var(--primaryColor);
            }
            .panel p {
              padding: 20px;
              text-align: justify;
            }

            .blogx-primaryColor {
              background-color: var(--primaryColor);
            }

            body {
              background-image: url($blog_background$);
              background-position: center;
              background-repeat: no-repeat;
              background-size: cover;
              height: 100vh;
              width: 100%;
            }

            .hover:hover {
              text-decoration: underline;
              color: var(--secondaryColor);
            }

            .hoverPrimaryColor:hover {
              text-decoration: underline;
              color: var(--primaryColor) !important;
            }

            .noTextDecoration {
              text-decoration: none !important;
            }

            .blogx-secondaryColor {
              background-color: var(--secondaryColor);
            }

            .blogx-textPrimaryColor {
              color: var(--textPrimaryColor);
            }

            .blogx-textSecondaryColor {
              color: var(--textSecondaryColor);
            }

            .btn-login {
              margin-right: 20px;
              border: none;
              padding: 7px;
              border-radius: 5px;
            }
          </style>

            """;

    return html;

  }

  public static String controlPanelEntrysPage() {

    String html = """
                    <!DOCTYPE html>
                    <html lang='es'>

                    <head>
                      <meta charset='UTF-8'>
                      <meta http-equiv='X-UA-Compatible' content='IE=edge'>
                      <meta name='viewport' content='width=device-width, initial-scale=1.0'>
                      <title>$blog_name$ | Control Panel</title>
                      <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet'
                        integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>
                      <link rel='stylesheet' href='web_resources/css/global.css'>
                      <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css' />
                      <link rel='stylesheet' href='web_resources/css/home/home.css'>
                    </head>

                    <body class='d-flex align-items-center text-center'>

          <div  class='container-fluid'>
            <div class='row'>

              <div  class='col-6 entrysListContainer'>
              <br>
              <br>
                <h3>Entradas</h3>
                $all_entrys$


              </div>
              <div class='col-6'  style='border-left: 1px solid var(--primaryColor);'>
              <br>
              <br>
                <h3>Nueva Entrada</h3>
                  <form action='/WebBlog/ControlPanelInsertEntry' method='post'>
                    <label for='title'>Titulo:</label><br>
                    <input  type='text' name='title' required><br>
                    <label for='image'>URL imagen:</label><br>
                    <input type='text' name='image' required><br>
                    <label for='body'>Cuerpo:</label><br>
                    <textarea name='body' id='' cols='30' rows='10' required></textarea><br>
                    <input type='submit' class='submitButton'>
                  </form>

              </div>

            </div>
          </div>

        </body>

                    </html>

                    <style>
                    :root {
                      --primaryColor: $primary_color$;
                      --secondaryColor: $secondary_color$;
                      --textPrimaryColor: $text_primary_color$;
                      --textSecondaryColor: $text_secondary_color$;
                    }
                    .entrysListContainer{
                      max-height: 700px;
                      overflow: scroll;
                    }
                    .submitButton{
                        border-radius: 10px;
                        padding: 5px;
                        background-color: var(--primaryColor);
                        border: none;
                        transition: 0.2s;
                        color: var(--textPrimaryColor);
                        margin-top: 5px;
                    }

                    .submitButton:hover{
                        transform: scale(1.1);
                    }

                    .formEditEntry{
                      margin-top: 10px;
                      border: 2px dotted var(--primaryColor);
                      border-radius: 10px;
                      padding: 10px;
                      background-color: var(--secondaryColor);
                      overflow: hidden;
                    }

                    .formEditEntry:hover{
                      border: 2px solid var(--primaryColor);
                      box-shadow: 2px 2px 2px 1px rgba(0, 0, 0, 0.2);
                    }

                    .navBarShadow{
                      box-shadow: 0 4px 10px -2px gray;
                    }

                    .panel {
                      background-color: #EDF2F4;
                      min-height: 700px;
                      width: 900px;
                      border-radius: 10px;
                      flex-direction: column;
                      margin-top: 40px;
                      box-shadow: 0px 0px 10px 2px rgba(0, 0, 0, 0.486);
                    }
                    .panel h1{
                      margin-top: 20px;
                      text-decoration: underline var(--primaryColor);
                    }

                    .panel img {
                      width: 900px;
                      border-top-left-radius: 10px;
                      border-top-right-radius: 10px;
                      border-top-left-radius: 10px;
                      height: 500px;
                      border-bottom: 2px solid var(--primaryColor);
                    }
                    .panel p {
                      padding: 20px;
                      text-align: justify;
                    }

                    .blogx-primaryColor {
                      background-color: var(--primaryColor);
                    }

                    body {
                      /* background-image: url(./web_resources/images/installer/installer_background.jpg); */
                      background-position: center;
                      background-repeat: no-repeat;
                      background-size: cover;
                      height: 100vh;
                      width: 100%;
                    }

                    .hover:hover {
                      text-decoration: underline;
                      color: var(--secondaryColor);
                    }

                    .hoverPrimaryColor:hover {
                      text-decoration: underline;
                      color: var(--primaryColor) !important;
                    }

                    .noTextDecoration {
                      text-decoration: none !important;
                    }

                    .blogx-secondaryColor {
                      background-color: var(--secondaryColor);
                    }

                    .blogx-textPrimaryColor {
                      color: var(--textPrimaryColor);
                    }

                    .blogx-textSecondaryColor {
                      color: var(--textSecondaryColor);
                    }

                    .btn-login {
                      margin-right: 20px;
                      border: none;
                      padding: 7px;
                      border-radius: 5px;
                    }
                  </style>

                    """;

    return html;

  }

  public static String controlPanelEditEntryPage() {

    String html = """
          <!DOCTYPE html>
          <html lang='es'>

          <head>
            <meta charset='UTF-8'>
            <meta http-equiv='X-UA-Compatible' content='IE=edge'>
            <meta name='viewport' content='width=device-width, initial-scale=1.0'>
            <title>$blog_name$ | Control Panel</title>
            <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet'
              integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>
            <link rel='stylesheet' href='web_resources/css/global.css'>
            <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css' />
            <link rel='stylesheet' href='web_resources/css/home/home.css'>
          </head>

          <body class='d-flex align-items-center text-center'>

          <div  class='container-fluid'>
            <div class='row'>
              <div class='col-12'>
                <h3>Editar Entrada</h3>
                  <form action='/WebBlog/ControlPanelUpdateEntry' method='post'>
                    <label for='title'>Titulo:</label><br>
                    <input style='width: 800px;' type='text' name='title' value='$entry_title$' required><br>
                    <label for='image'>URL imagen (para una mejor visualizaci&#243n, debe se cuadrada o rectangular):</label><br>
                    <input style='width: 800px;'  type='text' name='image'  value='$entry_image$' required><br>
                    <label for='body'>Cuerpo:</label><br>
                    <textarea style='width: 800px;'  name='body' cols='30' rows='10' required>$entry_body$</textarea><br>
                    <input type='submit' class='submitButton'>
                    <input type='hidden' value='$entry_id$' name='id'>
                  </form>
                  <form action='/WebBlog/ControlPanelDeleteEntry' method='post'>
                    <input type='submit' class='submitButton' value='Eliminar'>
                    <input type='hidden' value='$entry_id$' name='id'>
                  </form>

                  <button type='submit' class='submitButton' onclick='history.back()'>Volver</button>

              </div>

            </div>
          </div>

        </body>

          </html>

          <style>
          :root {
            --primaryColor: $primary_color$;
            --secondaryColor: $secondary_color$;
            --textPrimaryColor: $text_primary_color$;
            --textSecondaryColor: $text_secondary_color$;
          }
          .entrysListContainer{
            max-height: 700px;
            overflow: scroll;
          }
          .submitButton{
              border-radius: 10px;
              padding: 5px;
              background-color: var(--primaryColor);
              border: none;
              transition: 0.2s;
              color: var(--textPrimaryColor);
              margin-top: 5px;
              width: 100px;
          }

          .submitButton:hover{
              transform: scale(1.1);
          }

          .formEditEntry{
            margin-top: 10px;
            border: 2px dotted var(--primaryColor);
            border-radius: 10px;
            padding: 10px;
            background-color: var(--secondaryColor);
            overflow: hidden;
          }

          .formEditEntry:hover{
            border: 2px solid var(--primaryColor);
            box-shadow: 2px 2px 2px 1px rgba(0, 0, 0, 0.2);
          }

          .navBarShadow{
            box-shadow: 0 4px 10px -2px gray;
          }

          .panel {
            background-color: #EDF2F4;
            min-height: 700px;
            width: 900px;
            border-radius: 10px;
            flex-direction: column;
            margin-top: 40px;
            box-shadow: 0px 0px 10px 2px rgba(0, 0, 0, 0.486);
          }
          .panel h1{
            margin-top: 20px;
            text-decoration: underline var(--primaryColor);
          }

          .panel img {
            width: 900px;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            border-top-left-radius: 10px;
            height: 500px;
            border-bottom: 2px solid var(--primaryColor);
          }
          .panel p {
            padding: 20px;
            text-align: justify;
          }

          .blogx-primaryColor {
            background-color: var(--primaryColor);
          }

          body {
            /* background-image: url(./web_resources/images/installer/installer_background.jpg); */
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            height: 100vh;
            width: 100%;
          }

          .hover:hover {
            text-decoration: underline;
            color: var(--secondaryColor);
          }

          .hoverPrimaryColor:hover {
            text-decoration: underline;
            color: var(--primaryColor) !important;
          }

          .noTextDecoration {
            text-decoration: none !important;
          }

          .blogx-secondaryColor {
            background-color: var(--secondaryColor);
          }

          .blogx-textPrimaryColor {
            color: var(--textPrimaryColor);
          }

          .blogx-textSecondaryColor {
            color: var(--textSecondaryColor);
          }

          .btn-login {
            margin-right: 20px;
            border: none;
            padding: 7px;
            border-radius: 5px;
          }
        </style>

          """;

    return html;

  }

  public static String controlPanelEditUserPage() {

    String html = """
          <!DOCTYPE html>
          <html lang='es'>

          <head>
            <meta charset='UTF-8'>
            <meta http-equiv='X-UA-Compatible' content='IE=edge'>
            <meta name='viewport' content='width=device-width, initial-scale=1.0'>
            <title>$blog_name$ | Control Panel</title>
            <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet'
              integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>
            <link rel='stylesheet' href='web_resources/css/global.css'>
            <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css' />
            <link rel='stylesheet' href='web_resources/css/home/home.css'>
          </head>

          <body class='d-flex align-items-center text-center'>

          <div  class='container-fluid'>
            <div class='row'>
              <div class='col-12'>
                <h3>Editar usuario.</h3>
                  <form action='/WebBlog/ControlPanelUpdateUser' method='post'>
                    <span>$user_nick$</span><br>
                    <label for='oldPassword'>Contrase&#241a actual:</label><br>
                    <input style='width: 800px;'  type='password' name='oldPassword' required><br>
                    <label for='newPassword'>Contrase&#241a nueva:</label><br>
                    <input style='width: 800px;'  type='password' name='newPassword' required><br>
                    <label for='newPassword'>Admin: </label>
                    <input type='checkbox' name='admin' value='0' $set_checked$><br>
                    <input type='submit' class='submitButton'>
                    <input type='hidden' value='$user_nick$' name='nick'>
                  </form>
                  <form action='/WebBlog/ControlPanelDeleteUser' method='post'>
                    <input type='submit' class='submitButton' value='Eliminar'>
                    <input type='hidden' value='$user_nick$' name='nick'>
                  </form>

                  <button type='submit' class='submitButton' onclick='history.back()'>Volver</button>

              </div>

            </div>
          </div>

        </body>

          </html>

          <style>
          :root {
            --primaryColor: $primary_color$;
            --secondaryColor: $secondary_color$;
            --textPrimaryColor: $text_primary_color$;
            --textSecondaryColor: $text_secondary_color$;
          }
          .entrysListContainer{
            max-height: 700px;
            overflow: scroll;
          }
          .submitButton{
              border-radius: 10px;
              padding: 5px;
              background-color: var(--primaryColor);
              border: none;
              transition: 0.2s;
              color: var(--textPrimaryColor);
              margin-top: 5px;
              width: 100px;
          }

          .submitButton:hover{
              transform: scale(1.1);
          }

          .formEditEntry{
            margin-top: 10px;
            border: 2px dotted var(--primaryColor);
            border-radius: 10px;
            padding: 10px;
            background-color: var(--secondaryColor);
            overflow: hidden;
          }

          .formEditEntry:hover{
            border: 2px solid var(--primaryColor);
            box-shadow: 2px 2px 2px 1px rgba(0, 0, 0, 0.2);
          }

          .navBarShadow{
            box-shadow: 0 4px 10px -2px gray;
          }

          .panel {
            background-color: #EDF2F4;
            min-height: 700px;
            width: 900px;
            border-radius: 10px;
            flex-direction: column;
            margin-top: 40px;
            box-shadow: 0px 0px 10px 2px rgba(0, 0, 0, 0.486);
          }
          .panel h1{
            margin-top: 20px;
            text-decoration: underline var(--primaryColor);
          }

          .panel img {
            width: 900px;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            border-top-left-radius: 10px;
            height: 500px;
            border-bottom: 2px solid var(--primaryColor);
          }
          .panel p {
            padding: 20px;
            text-align: justify;
          }

          .blogx-primaryColor {
            background-color: var(--primaryColor);
          }

          body {
            /* background-image: url(./web_resources/images/installer/installer_background.jpg); */
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            height: 100vh;
            width: 100%;
          }

          .hover:hover {
            text-decoration: underline;
            color: var(--secondaryColor);
          }

          .hoverPrimaryColor:hover {
            text-decoration: underline;
            color: var(--primaryColor) !important;
          }

          .noTextDecoration {
            text-decoration: none !important;
          }

          .blogx-secondaryColor {
            background-color: var(--secondaryColor);
          }

          .blogx-textPrimaryColor {
            color: var(--textPrimaryColor);
          }

          .blogx-textSecondaryColor {
            color: var(--textSecondaryColor);
          }

          .btn-login {
            margin-right: 20px;
            border: none;
            padding: 7px;
            border-radius: 5px;
          }
        </style>

          """;

    return html;

  }

  public static String controlPanelUsersPage() {

    String html = """
                    <!DOCTYPE html>
                    <html lang='es'>

                    <head>
                      <meta charset='UTF-8'>
                      <meta http-equiv='X-UA-Compatible' content='IE=edge'>
                      <meta name='viewport' content='width=device-width, initial-scale=1.0'>
                      <title>$blog_name$ | Control Panel</title>
                      <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet'
                        integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>
                      <link rel='stylesheet' href='web_resources/css/global.css'>
                      <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css' />
                      <link rel='stylesheet' href='web_resources/css/home/home.css'>
                    </head>

                    <body class='d-flex align-items-center text-center'>

          <div  class='container-fluid'>
            <div class='row'>

              <div  class='col-6 entrysListContainer'  style='min-height: 700px;'>
              <br>
              <br>
                <h3>Usuarios</h3>
                $all_users$


              </div>
              <div class='col-6'  style='border-left: 1px solid var(--primaryColor);'  style='min-height: 700px;'>
              <br>
              <br>
                <h3>Nuevo Usuario</h3>
                  <form action='/WebBlog/ControlPanelInsertUser' method='post'>
                    <label for='nick'>Nombre:</label><br>
                    <input  type='text' name='nick' required><br>
                    <label for='password'>Contrase&#241a:</label><br>
                    <input type='text' name='password' required><br>
                    <label for='admin'>Admin</label>
                    <input type='checkbox' name='admin' value='0'><br>
                    <input type='submit' class='submitButton'>
                  </form>

              </div>

            </div>
          </div>

        </body>

                    </html>

                    <style>
                    :root {
                      --primaryColor: $primary_color$;
                      --secondaryColor: $secondary_color$;
                      --textPrimaryColor: $text_primary_color$;
                      --textSecondaryColor: $text_secondary_color$;
                    }
                    .entrysListContainer{
                      max-height: 700px;
                      overflow: scroll;
                    }
                    .submitButton{
                        border-radius: 10px;
                        padding: 5px;
                        background-color: var(--primaryColor);
                        border: none;
                        transition: 0.2s;
                        color: var(--textPrimaryColor);
                        margin-top: 5px;
                    }

                    .submitButton:hover{
                        transform: scale(1.1);
                    }

                    .formEditEntry{
                      margin-top: 10px;
                      border: 2px dotted var(--primaryColor);
                      border-radius: 10px;
                      padding: 10px;
                      background-color: var(--secondaryColor);
                      overflow: hidden;
                    }

                    .formEditEntry:hover{
                      border: 2px solid var(--primaryColor);
                      box-shadow: 2px 2px 2px 1px rgba(0, 0, 0, 0.2);
                    }

                    .navBarShadow{
                      box-shadow: 0 4px 10px -2px gray;
                    }

                    .panel {
                      background-color: #EDF2F4;
                      min-height: 700px;
                      width: 900px;
                      border-radius: 10px;
                      flex-direction: column;
                      margin-top: 40px;
                      box-shadow: 0px 0px 10px 2px rgba(0, 0, 0, 0.486);
                    }
                    .panel h1{
                      margin-top: 20px;
                      text-decoration: underline var(--primaryColor);
                    }

                    .panel img {
                      width: 900px;
                      border-top-left-radius: 10px;
                      border-top-right-radius: 10px;
                      border-top-left-radius: 10px;
                      height: 500px;
                      border-bottom: 2px solid var(--primaryColor);
                    }
                    .panel p {
                      padding: 20px;
                      text-align: justify;
                    }

                    .blogx-primaryColor {
                      background-color: var(--primaryColor);
                    }

                    body {
                      /* background-image: url(./web_resources/images/installer/installer_background.jpg); */
                      background-position: center;
                      background-repeat: no-repeat;
                      background-size: cover;
                      height: 100vh;
                      width: 100%;
                    }

                    .hover:hover {
                      text-decoration: underline;
                      color: var(--secondaryColor);
                    }

                    .hoverPrimaryColor:hover {
                      text-decoration: underline;
                      color: var(--primaryColor) !important;
                    }

                    .noTextDecoration {
                      text-decoration: none !important;
                    }

                    .blogx-secondaryColor {
                      background-color: var(--secondaryColor);
                    }

                    .blogx-textPrimaryColor {
                      color: var(--textPrimaryColor);
                    }

                    .blogx-textSecondaryColor {
                      color: var(--textSecondaryColor);
                    }

                    .btn-login {
                      margin-right: 20px;
                      border: none;
                      padding: 7px;
                      border-radius: 5px;
                    }
                  </style>

                    """;

    return html;

  }
  public static String controlPanelPickThemePage() {

    String html = """
    <!DOCTYPE html>
    <html lang='es'>
    
    <head>
      <meta charset='UTF-8'>
      <meta http-equiv='X-UA-Compatible' content='IE=edge'>
      <meta name='viewport' content='width=device-width, initial-scale=1.0'>
      <title>$blog_name$ | Control Panel</title>
      <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet'
        integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>
      <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js'
        integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p'
        crossorigin='anonymous'></script>
      <link rel='stylesheet' href='web_resources/css/global.css'>
      <link rel='stylesheet' href='web_resources/css/installer/installerDataCollect.css'>
      <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css' />
    </head>
    
    <body class='d-flex align-items-center text-center'>
    
      <div class='container-fluid'>
        <div class='row'>
          <div class='col-12' style='min-height: 650px;'>
            <h3>Editar Tema</h3>
    
    
            <select name='themes' onchange='changeTheme()' id='select'>
              <option value='1'>BlogX</option>
              <option value='2'>Vino</option>
              <option value='3'>Cielo</option>
              <option value='4'>Cesped</option>
              <option value='5' selected='selected'>Personalizado</option>
            </select>
            <br><br>
            <form action='/WebBlog/ControlPanelUpdateTheme' method='post'>
              <label for='blogName'>Nombre del Blog:</label><br>
              <input id='blogName' style='width: 800px;' type='text' name='blogName' value='$blog_name$' required><br>
    
              <label for='primaryColor'>Color primario:</label><br>
              <input id='primaryColor' style='width: 800px;' type='text' name='primaryColor' value='$primary_color$'
                required><br>
    
              <label for='secondaryColor'>Color secundario:</label><br>
              <input id='secondaryColor' style='width: 800px;' type='text' name='secondaryColor' value='$secondary_color$'
                required><br>
    
              <label for='primaryColorText'>Color primario texto:</label><br>
              <input id='primaryColorText' style='width: 800px;' type='text' name='primaryColorText'
                value='$text_primary_color$' required><br>
    
              <label for='secondaryColorText'>Color secundario texto:</label><br>
              <input id='secondaryColorText' style='width: 800px;' type='text' name='secondaryColorText'
                value='$text_secondary_color$' required><br>
    
              <label for='blogImage'>Fondo Blog (imagen rectagular o cuadrada para una mejor calidad):</label><br>
              <input id='blogImage' style='width: 800px;' type='text' name='blogImage' value='$blog_background$' required><br>
              <a href='https://unsplash.com/' target='_blank'>UnSplash</a><br>
    
              <input type='submit' class='submitButton'>
            </form>
    
          </div>
    
        </div>
      </div>
    
      <script type='text/javascript'>
        var blogName = document.getElementById('blogName');
        var primaryColor = document.getElementById('primaryColor');
        var secondaryColor = document.getElementById('secondaryColor');
        var primaryColorText = document.getElementById('primaryColorText');
        var secondaryColorText = document.getElementById('secondaryColorText');
        var blogImage = document.getElementById('blogImage');
        var select = document.getElementById('select');
    
        function changeTheme() {
          if (select.value == 1) {
            blogxTheme();
          } else if (select.value == 2) {
            wineTheme();
          } else if (select.value == 3) {
            skyTheme();
          } else if (select.value == 4) {
            grassTheme();
          } else {
            emptyTheme();
          }
        }
    
        function blogxTheme() {
          blogName.value = 'BlogX';
          primaryColor.value = '#f2007a';
          secondaryColor.value = '#EDF2F4';
          primaryColorText.value = '#ffffff';
          secondaryColorText.value = '#000000';
          blogImage.value = 'https://images.unsplash.com/photo-1557682224-5b8590cd9ec5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1129&q=80';
        }
    
        function wineTheme() {
          blogName.value = 'BlogX';
          primaryColor.value = '#7a6ac0';
          secondaryColor.value = '#EDF2F4';
          primaryColorText.value = '#ffffff';
          secondaryColorText.value = '#000000';
          blogImage.value = 'https://images.unsplash.com/photo-1557682250-33bd709cbe85?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1129&q=80';
        }
    
        function skyTheme() {
          blogName.value = 'BlogX';
          primaryColor.value = '#6699ff';
          secondaryColor.value = '#EDF2F4';
          primaryColorText.value = '#ffffff';
          secondaryColorText.value = '#000000';
          blogImage.value = 'https://images.unsplash.com/photo-1557683311-eac922347aa1?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1129&q=80';
        }
    
        function grassTheme() {
          blogName.value = 'BlogX';
          primaryColor.value = '#73e600';
          secondaryColor.value = '#EDF2F4';
          primaryColorText.value = '#ffffff';
          secondaryColorText.value = '#000000';
          blogImage.value = 'https://images.unsplash.com/photo-1614850523503-6e4ef43bee40?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80';
        }
    
        function emptyTheme() {
          blogName.value = '';
          primaryColor.value = '';
          secondaryColor.value = '';
          primaryColorText.value = '';
          secondaryColorText.value = '';
          blogImage.value = '';
        }
    
    
    
    
      </script>
    
    </body>
    
    </html>
    
    <style>
      :root {
        --primaryColor: $primary_color$;
        --secondaryColor: $secondary_color$;
        --textPrimaryColor: $text_primary_color$;
        --textSecondaryColor: $text_secondary_color$;
      }
    
      .entrysListContainer {
        max-height: 700px;
        overflow: scroll;
      }
    
      .navBarShadow {
        box-shadow: 0 4px 10px -2px gray;
      }
    
      .submitButton {
        border-radius: 10px;
        padding: 5px;
        background-color: var(--primaryColor);
        border: none;
        transition: 0.2s;
        color: var(--textPrimaryColor);
        margin-top: 5px;
      }
    
      .submitButton:hover {
        transform: scale(1.1);
      }
    
      .formEditEntry {
        margin-top: 10px;
        border: 2px dotted var(--primaryColor);
        border-radius: 10px;
        padding: 10px;
        background-color: var(--secondaryColor);
        overflow: hidden;
      }
    
      .formEditEntry:hover {
        border: 2px solid var(--primaryColor);
        box-shadow: 2px 2px 2px 1px rgba(0, 0, 0, 0.2);
      }
    
      .panel {
        background-color: #EDF2F4;
        min-height: 700px;
        width: 900px;
        border-radius: 10px;
        flex-direction: column;
        margin-top: 40px;
        box-shadow: 0px 0px 10px 2px rgba(0, 0, 0, 0.486);
      }
    
      .panel h1 {
        margin-top: 20px;
        text-decoration: underline var(--primaryColor);
      }
    
      .panel img {
        width: 900px;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
        border-top-left-radius: 10px;
        height: 500px;
        border-bottom: 2px solid var(--primaryColor);
      }
    
      .panel p {
        padding: 20px;
        text-align: justify;
      }
    
      .blogx-primaryColor {
        background-color: var(--primaryColor);
      }
    
      body {
        /* background-image: url(./web_resources/images/installer/installer_background.jpg); */
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
        height: 100vh;
        width: 100%;
      }
    
      .hover:hover {
        text-decoration: underline;
        color: var(--secondaryColor);
      }
    
      .hoverPrimaryColor:hover {
        text-decoration: underline;
        color: var(--primaryColor) !important;
      }
    
      .noTextDecoration {
        text-decoration: none !important;
      }
    
      .blogx-secondaryColor {
        background-color: var(--secondaryColor);
      }
    
      .blogx-textPrimaryColor {
        color: var(--textPrimaryColor);
      }
    
      .blogx-textSecondaryColor {
        color: var(--textSecondaryColor);
      }
    
      .btn-login {
        margin-right: 20px;
        border: none;
        padding: 7px;
        border-radius: 5px;
      }
    </style>
                    """;

    return html;

  }

  public static String updateWeb(){
    String html = """
    <!DOCTYPE html>
    <html lang='es'>
    
    <head>
      <meta charset='UTF-8'>
      <meta http-equiv='X-UA-Compatible' content='IE=edge'>
      <meta name='viewport' content='width=device-width, initial-scale=1.0'>
      <title>$blog_name$ | Update Window</title>
      <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet'
        integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>
      <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js'
        integrity='sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p'
        crossorigin='anonymous'></script>
      <link rel='stylesheet' href='web_resources/css/global.css'>
      <link rel='stylesheet' href='web_resources/css/installer/installerDataCollect.css'>
      <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css' />
    </head>
    
    <body class='d-flex align-items-center text-center'>
    
      <div class='container-fluid'>
        <div class='row'>
          <div class='col-12' style='max-height: 650px;'>
            <h3>Actualiza la pestaña</h3>
            <h3>O pulsa F5.</h3>
            
            <img width='500px' src='./web_resources/images/login/update.svg' alt=''>
    
          </div>
    
        </div>
      </div>
    
    </body>
    
    </html>
    
    
    """;

    return html;
  }

  public static String controlPanelEntryForm() {
    String html = """

        <form class='formEditEntry' action='/WebBlog/ControlPanelEditEntry' method='post'>
              <span>$entry_title$</span><br>
              <span>Fecha: $entry_date$</span>
              <input type='hidden' name='id' value='$entry_id$'><br>
              <input class='submitButton' type='submit' value='Editar'>
            </form>

        """;

    return html;
  }

  public static String controlPanelUserForm() {
    String html = """

        <form class='formEditEntry' action='/WebBlog/ControlPanelEditUser' method='post'>
              <span>$user_nick$</span><br>
              <input type='hidden' name='ncik' value='$user_nick$'><br>
              <input class='submitButton' type='submit' value='Editar'>
            </form>

        """;

    return html;
  }

  public static String RedirectPage() {
    String htnml = """
        <!DOCTYPE html>
        <html lang='en'>
        <head>
          <meta charset='UTF-8'>
          <meta http-equiv='X-UA-Compatible' content='IE=edge'>
          <meta name='viewport' content='width=device-width, initial-scale=1.0'>
          <meta http-equiv='refresh' content='1; url=/WebBlog/home' />
          <title>$blog_name$ | Redirecting...</title>
        </head>
        <body>

        </body>
        </html>
                                    """;

    return htnml;
  }

  public static String loginButton() {

    String htnml = """
        <a href='/WebBlog/login'><button type='button' class='secondaryColor btn-login '>Inciar sesi&#243n</button></a>
                """;

    return htnml;
  }

  public static String logOutButton() {

    String htnml = """
        <a href='/WebBlog/logout'><button type='button' class='secondaryColor btn-login '>Cerrar sesi&#243n</button></a>
                """;

    return htnml;
  }

  public static String entryBody() {

    String htnml = """
          <a href='/WebBlog/entry?id=$id_entry$' class='col-3 noTextDecoration'>
          <div class='card ' style='width: 18rem;'>
            <img
              src='$entry_image$'
              class='card-img-top entryImage' alt='error_insert_an_image'>
            <div class='card-body'>
              <p class='card-text text-black hoverPrimaryColor text-truncate'>$card_title$</p>
            </div>
          </div>
        </a>
                      """;

    return htnml;
  }

  public static String controlPanelNav() {

    String htnml = """
        <li class='nav-item'>
        <a class='nav-link blogx-textPrimaryColor hover' href='/WebBlog/controlpanel'>Panel de Control</a>
        </li>
                          """;

    return htnml;
  }

}