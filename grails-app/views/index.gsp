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
            <div class="row">
                <h1 style="font-size: 40px;">D&D Black Flag</h1>
            </div>
            <h2 style="font-size: 24px;">An unofficial digital toolset for Dungeons & Dragons Fifth Edition</h2>

            <sec:ifNotLoggedIn>
            <div class="row">
                <a href="/login/auth">
                    <button class="bannerButton">
                        <asset:image src="PirateBanner.png"/>
                        <p class="bannerText">Log In</p>
                    </button>
                </a>
                <a href="/login/register">
                    <button class="bannerButton">
                        <asset:image src="PirateBanner.png"/>
                        <p class="bannerHeader">Set Sail!</p>
                        <p class="bannerSubText">Create Account</p>
                    </button>
                </a>
            </div>
            </sec:ifNotLoggedIn>

            <sec:ifLoggedIn>

            <div class="row">
                <div class="col">
                    <a href="/#">
                        <button class="bannerButton">
                            <asset:image src="PirateBanner.png"/>
                            <p class="bannerText" style="color: red">My Content</p>
                        </button>
                    </a>
                </div>
                <div class="col">
                    <a href="/compendium">
                        <button class="bannerButton">
                            <asset:image src="PirateBanner.png"/>
                            <p class="bannerText">Compendium</p>
                        </button>
                    </a>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <a href="/downloads/index">
                        <button class="bannerButton">
                            <asset:image src="PirateBanner.png"/>
                            <p class="bannerText">Downloads</p>
                        </button>
                    </a>
                </div>
                <div class="col">
                    <a href="/user/index">
                        <button class="bannerButton">
                            <asset:image src="PirateBanner.png"/>
                            <p class="bannerText">Profile</p>
                        </button>
                    </a>
                </div>
            </div>

            <a href="/logout">
                <button class="bannerButton">
                    <asset:image src="PirateBanner.png"/>
                    <p class="bannerText">Log Out</p>
                </button>
            </a>
            </sec:ifLoggedIn>

    </div>
</div>

</body>
</html>
