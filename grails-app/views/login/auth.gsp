<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>D&D Black Flag</title>
    <asset:javascript src="sendMessage.js"/>
    <asset:link rel="icon" href="BlackFlagLogo.ico" type="image/x-ico"/>
    <asset:stylesheet href="home.css"/>
</head>
<body>
<g:render template="/navbar" />

<div role="main" class="homePage">
    <div class="mainMenu">
            
        <g:if test="${flash.message}">
            <div class="alert alert-error" style="text-align: center; font-size: large; color:red;">${flash.message}</div>
        </g:if>

        <g:if test="${params.errorMessage != null}">
            <div class="alert alert-error" style="text-align: center; font-size: large; color:red;">${errorMessage}</div>
        </g:if>

        <form action="${postUrl ?: '/login/authenticate'}" style="text-align: center" method="POST" id="loginForm" class="cssform" autocomplete="off">
            <div class="row">
                <p class="flexible-right">
                    <label for="username" style="font-size: 20px; white-space: pre;">Username: </label>
                    <input type="text" class="text_" name="${usernameParameter ?: 'username'}" id="username"/>
                </p>
            </div>

            <div class="row">
                <p class="flexible-right">
                    <label for="password" style="font-size: 20px; white-space: pre;">Password:  </label>
                    <input type="password" class="text_" name="${passwordParameter ?: 'password '}" id="password"/>
                </p>
            </div>

            <div style="align-items: center">
                <p>
                    <input type="submit" class="btn btn-lg btn-light" id="submit" value="${message(code: 'springSecurity.login.button')}"/>
                </p>
            </div>

        </form>

    </div>
</div>

</body>
</html>
