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

<div role="main" class="longPage">
    <div class="mainMenu">
            <div style="align-items: left; width: 100%">
                <a href="/compendium">
                    <button class="backbtn">
                        <p>Back</p>
                    </button>
                </a>
            </div>

            <div class="row">
                <h1 style="font-size: 40px;">D&D 5e Vehicles</h1>
            </div>

            <h2 style="Font-size: 28px;">Ghosts of Saltmarsh</h2>
            <div class="row">
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Galley" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Galley</p>
                        </button>
                    </g:form>
                </div>
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Keelboat" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Keelboat</p>
                        </button>
                    </g:form>
                </div>
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Longship" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Longship</p>
                        </button>
                    </g:form>
                </div>
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Rowboat" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Rowboat</p>
                        </button>
                    </g:form>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Sailing Ship" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Sailing Ship</p>
                        </button>
                    </g:form>
                </div>
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Warship" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Warship</p>
                        </button>
                    </g:form>
                </div>
            </div>

            <h2 style="Font-size: 28px;">Acquisitions Incorporated</h2>
            <div class="row">
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Battle Balloon" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Battle Balloon</p>
                        </button>
                    </g:form>
                </div>
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Mechanical Beholder" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Mechanical Beholder</p>
                        </button>
                    </g:form>
                </div>
            </div>

            <h2 style="Font-size: 28px;">Baldur's Gate: Descent into Avernus</h2>
            <div class="row">
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Demon Grinder" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Demon Grinder</p>
                        </button>
                    </g:form>
                </div>
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Devil's Ride" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Devil's Ride</p>
                        </button>
                    </g:form>
                </div>
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Scavenger" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Scavenger</p>
                        </button>
                    </g:form>
                </div>
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Tormentor" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Tormentor</p>
                        </button>
                    </g:form>
                </div>
            </div>

            <h2 style="Font-size: 28px;">Spelljammer: Adventures in Space</h2>
            <div class="row">
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Bombard" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Bombard</p>
                        </button>
                    </g:form>
                </div>
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Damselfly Ship" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Damselfly Ship</p>
                        </button>
                    </g:form>
                </div>
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Flying Fish Ship" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Flying Fish Ship</p>
                        </button>
                    </g:form>
                </div>
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Hammerhead Ship" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Hammerhead Ship</p>
                        </button>
                    </g:form>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Lamprey Ship" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Lamprey Ship</p>
                        </button>
                    </g:form>
                </div>
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Living Ship" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Living Ship</p>
                        </button>
                    </g:form>
                </div>
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Nautiloid" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Nautiloid</p>
                        </button>
                    </g:form>
                </div>
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Nightspider" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Nightspider</p>
                        </button>
                    </g:form>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Scorpion Ship" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Scorpion Ship</p>
                        </button>
                    </g:form>
                </div>
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Shrike Ship" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Shrike Ship</p>
                        </button>
                    </g:form>
                </div>
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Space Galleon" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Squid Ship</p>
                        </button>
                    </g:form>
                </div>
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Star Moth" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Star Moth</p>
                        </button>
                    </g:form>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Turtle Ship" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Turtle Ship</p>
                        </button>
                    </g:form>
                </div>
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Tyrant Ship" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Tyrant Ship</p>
                        </button>
                    </g:form>
                </div>
                <div class="col">
                    <g:form controller="compendium" action="vehicle">
                        <button class="classBannerButton">
                            <g:hiddenField name="vehicle" value="Wasp Ship" />
                            <asset:image src="compendiumIcons/gate.png" class="homeBannerImage"/>
                            <asset:image src="PirateBanner.png" class="classBanner"/>
                            <p class="classBannerText">Wasp Ship</p>
                        </button>
                    </g:form>
                </div>
            </div>

    </div>
</div>

</body>
</html>
