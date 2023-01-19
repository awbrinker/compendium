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
                <a href="/compendium">
                    <button class="backbtn">
                        <p>Back</p>
                    </button>
                </a>
            </div>

            <h1 style="font-size: 32px; margin-top: 0px; margin-bottom: 10px">D&D 5e Classes</h1>

            <div class="row">
                <div class="col">
                    <a href="/#">
                        <button class="classBannerButton">
                            <asset:image src="classIcons/barbarian.png" class="classBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Barbarian</p>
                        </button>
                    </a>
                </div>
                <div class="col">
                    <a href="/#">
                        <button class="classBannerButton">
                            <asset:image src="classIcons/bard.png" class="classBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Bard</p>
                        </button>
                    </a>
                </div>
                <div class="col">
                    <a href="/compendium/backgrounds">
                        <button class="classBannerButton">
                            <asset:image src="classIcons/cleric.png" class="classBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Cleric</p>
                        </button>
                    </a>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <a href="/compendium/feats">
                        <button class="classBannerButton">
                            <asset:image src="classIcons/druid.png" class="classBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Druid</p>
                        </button>
                    </a>
                </div>
                <div class="col">
                    <a href="/compendium/spells">
                        <button class="classBannerButton">
                            <asset:image src="classIcons/fighter.png" class="classBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Fighter</p>
                        </button>
                    </a>
                </div>
                <div class="col">
                    <a href="/#">
                        <button class="classBannerButton">
                            <asset:image src="classIcons/monk.png" class="classBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Monk</p>
                        </button>
                    </a>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <a href="/compendium/equipment">
                        <button class="classBannerButton">
                            <asset:image src="classIcons/paladin.png" class="classBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Paladin</p>
                        </button>
                    </a>
                </div>
                <div class="col">
                    <a href="/compendium/magicitems">
                        <button class="classBannerButton">
                            <asset:image src="classIcons/ranger.png" class="classBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Ranger</p>
                        </button>
                    </a>
                </div>
                <div class="col">
                    <a href="/#">
                        <button class="classBannerButton">
                            <asset:image src="classIcons/rogue.png" class="classBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Rogue</p>
                        </button>
                    </a>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <a href="/compendium/equipment">
                        <button class="classBannerButton">
                            <asset:image src="classIcons/sorcerer.png" class="classBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Sorcerer</p>
                        </button>
                    </a>
                </div>
                <div class="col">
                    <a href="/compendium/magicitems">
                        <button class="classBannerButton">
                            <asset:image src="classIcons/warlock.png" class="classBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Warlock</p>
                        </button>
                    </a>
                </div>
                <div class="col">
                    <a href="/#">
                        <button class="classBannerButton">
                            <asset:image src="classIcons/wizard.png" class="classBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Wizard</p>
                        </button>
                    </a>
                </div>
            </div>

            <a href="/compendium/equipment">
                <button class="classBannerButton">
                    <asset:image src="classIcons/artificer.png" class="classBannerImage"/>
                    <asset:image src="PirateBanner.png" class="classBanner"/>
                    <p class="classBannerText">Artificer</p>
                </button>
            </a>

    </div>
</div>

</body>
</html>
