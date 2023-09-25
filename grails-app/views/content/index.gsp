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
            <div style="align-items: left; width: 100%">
                <a href="/#">
                    <button class="backbtn">
                        <p>Back</p>
                    </button>
                </a>
            </div>

            <h1 style="font-size: 32px; margin-top: 0px; margin-bottom: 10px">Characters</h1>

            <div class="row">
                <div class="col">
                    <a href="/content/sentinel">
                        <button class="classBannerButton">
                            <asset:image src="charart/sentinel.png" class="classBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Sentinel</p>
                        </button>
                    </a>
                </div>
                <div class="col">
                    <a href="/content/valakhad">
                        <button class="classBannerButton">
                            <asset:image src="charart/valakhad.png" class="classBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Valakhad</p>
                        </button>
                    </a>
                </div>
                <div class="col">
                    <a href="/content/rivaan">
                        <button class="classBannerButton">
                            <asset:image src="charart/rivaan.png" class="classBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Rivaan</p>
                        </button>
                    </a>
                </div>
            </div>

    </div>
</div>

</body>
</html>
