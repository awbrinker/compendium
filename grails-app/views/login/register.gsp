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
<content tag="nav">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">My Content<span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li class="dropdown-item"><a href="#">Characters</a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Compendium <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li class="dropdown-item"><a href="#">Races</a></li>
            <li class="dropdown-item"><a href="#">Classes</a></li>
            <li class="dropdown-item"><a href="#">Backgrounds</li>
            <li class="dropdown-item"><a href="#">Feats</li>
            <li role="separator" class="dropdown-divider"></li>
            <li class="dropdown-item"><a href="#">Equipment </li>
            <li class="dropdown-item"><a href="#">Vehicles</a></li>
            <li class="dropdown-item"><a href="#">Magic Items</a></li>
            <li role="separator" class="dropdown-divider"></li>
            <li class="dropdown-item"><a href="#">Spells</a></li>
            <li class="dropdown-item"><a href="#">Monsters</a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Downloads <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li class="dropdown-item"><a href="/downloads/sources">Sources </a></li>
            <li class="dropdown-item"><a href="/downloads/tools">Tools </a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Profile <span class="caret"></span></a>
        <ul class="dropdown-menu dropdown-menu-right">
            <li class="dropdown-item"><a href="/login/auth">Log in </a></li>
        </ul>
    </li>
</content>

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
