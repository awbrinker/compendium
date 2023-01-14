<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>D&D Black Flag</title>
    <asset:javascript src="register.js"/>
    <asset:link rel="icon" href="BlackFlagLogo.ico" type="image/x-ico"/>
    <asset:stylesheet href="home.css"/>
</head>
<body>
<g:render template="/navbar" />

<div role="main" class="homePage">
    <div class="mainMenu">
            
        <g:if test="${params.errorMessage != null}">
            <div class="alert alert-error" style="text-align: center; font-size: large; color:red;">${errorMessage}</div>
        </g:if>

        <g:form style="text-align: left" controller="login" action="createAccount">

                    <label for="valCode">Enter your desired username:</label>
                    <g:textField name="username"/> <br>

                    <br><br>
                    Your password must be at least 7 characters, and contain:
                    <ul style="text-align: left">
                        <li>A lowercase letter</li>
                        <li>An uppercase letter</li>
                        <li>A number</li>
                        <li>A special character</li>
                    </ul>

                    <label for="password">Enter your desired password:</label>
                    <g:passwordField name="password"/><br><br>

                    <label for="cpassword">Confirm your password:</label>
                    <g:passwordField name="cpassword"/><br><br>
                </p>

                <button class="bannerButton" onclick="return validate();">
                    <asset:image src="PirateBanner.png"/>
                    <p class="bannerHeader">Set Sail!</p>
                </button>
            
            </g:form>

    </div>
</div>

</body>
</html>
