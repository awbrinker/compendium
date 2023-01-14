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
