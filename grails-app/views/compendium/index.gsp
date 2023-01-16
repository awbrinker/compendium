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
                <h1 style="font-size: 40px;">D&D 5e Compendium</h1>
            </div>

            <div class="row">
                <div class="col">
                    <a href="/compendium/classes">
                        <button class="classBannerButton">
                            <asset:image src="compendiumIcons/class.svg" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Classes</p>
                        </button>
                    </a>
                </div>
                <div class="col">
                    <a href="/compendium/races">
                        <button class="classBannerButton">
                            <asset:image src="compendiumIcons/race.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Races</p>
                        </button>
                    </a>
                </div>
                <div class="col">
                    <a href="/compendium/backgrounds">
                        <button class="classBannerButton">
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Backgrounds</p>
                        </button>
                    </a>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <a href="/compendium/feats">
                        <button class="classBannerButton">
                            <asset:image src="compendiumIcons/feat.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Feats</p>
                        </button>
                    </a>
                </div>
                <div class="col">
                    <a href="/compendium/spells">
                        <button class="classBannerButton">
                            <asset:image src="compendiumIcons/spell.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Spells</p>
                        </button>
                    </a>
                </div>
                <div class="col">
                    <a href="/compendium/monsters">
                        <button class="classBannerButton">
                            <asset:image src="compendiumIcons/monster.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Monsters</p>
                        </button>
                    </a>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <a href="/compendium/equipment">
                        <button class="classBannerButton">
                            <asset:image src="compendiumIcons/plate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Equipment</p>
                        </button>
                    </a>
                </div>
                <div class="col">
                    <a href="/compendium/magicitems">
                        <button class="classBannerButton">
                            <asset:image src="compendiumIcons/demonomicon.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Magic Items</p>
                        </button>
                    </a>
                </div>
                <div class="col">
                    <a href="/compendium/vehicles">
                        <button class="classBannerButton">
                            <asset:image src="compendiumIcons/mechanicalbeholder.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Vehicles</p>
                        </button>
                    </a>
                </div>
            </div>

    </div>
</div>

</body>
</html>
