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
    <sec:ifLoggedIn>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><sec:username/><span class="caret"></span></a>
                <ul class="dropdown-menu dropdown-menu-right">
                    <li class="dropdown-item"><a href="#">View Profile</a></li>
                    <li class="dropdown-item"><g:link class="nav-link" controller="Logout">Log out</g:link></li>
                </ul>
            </li>
    </sec:ifLoggedIn>
    <sec:ifNotLoggedIn>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Profile <span class="caret"></span></a>
            <ul class="dropdown-menu dropdown-menu-right">
                <li class="dropdown-item"><a href="/login/auth">Log in </a></li>
            </ul>
        </li>
    </sec:ifNotLoggedIn>
</content>

<div role="main" class="homePage">
    <div class="mainMenu">
            <div class="row">
                <h1 style="font-size: 40px;">D&D Black Flag</h1>
            </div>
            <h2 style="font-size: 24px;">An unofficial digital toolset for Dungeons & Dragons Fifth Edition</h2>

            <sec:ifNotLoggedIn>
            <a href="/login/auth">
                <button class="bannerButton">
                    <asset:image src="PirateBanner.png"/>
                    <p class="bannerText">Log In</p>
                </button>
            </a>
            </sec:ifNotLoggedIn>

            <sec:ifLoggedIn>
            <a href="/logout">
                <button class="bannerButton">
                    <asset:image src="PirateBanner.png"/>
                    <p class="bannerText">Log Out</p>
                </button>
            </a>
            </sec:ifLoggedIn>

            <sec:ifNotLoggedIn>
            <a href="/login/register">
                <button class="bannerButton">
                    <asset:image src="PirateBanner.png"/>
                    <p class="bannerHeader">Set Sail!</p>
                    <p class="bannerSubText">Create Account</p>
                </button>
            </a>
            </sec:ifNotLoggedIn>

            <%-- <div class="row">
                <h1>Test Discord Integration:</h1>
            </div>

            <div class="row">
                <p>Enter a message or dice formula:</p>
                <g:textField name="text" style="margin-left: 10px"/>
            </div>

            <div class="row">
                <button onclick="sendMessage('text')">
                        Send to Discord
                    </button>
            </div> --%>
    </div>
</div>

</body>
</html>
