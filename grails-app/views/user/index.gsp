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
                <h1>Update default page size:</h1>
            </div>

            <div class="row">
                <g:form style="text-align: left" action="updateLoad" autocomplete="off">
                    <g:textField name="load" style="margin-left: 10px; width: 500px" value="${load}"/>
                    <button class="button">Save</button>
                </g:form>
            </div>
            <div class="row" style="max-width: 500px">
                <p>This setting controls the number of items that are loaded at a single time on compendium pages.
                A higher number will result in slower initial loads, while a lower number may require you to frequently reload
                the page to view more items.  Be careful--if you set this too high, pages may fail to load entirely!</p>
            </div>

            <div class="row" style="margin: 16px"><hr/></div>

            <div class="row">
                <h1>Update default webhook:</h1>
            </div>

            <div class="row">
                <g:form style="text-align: left" action="updateHook" autocomplete="off">
                    <g:textField name="target" style="margin-left: 10px; width: 500px" value="${hook}"/>
                    <button class="button">Save</button>
                </g:form>
            </div>
            <div class="row" style="max-width: 500px">
                <p>This controls the URL that roll and display requests are sent to in the compendium.  For character sheets,
                this is only used if the character specific hook URL is not set.</p>
            </div>

            <div class="row" style="margin: 16px"><hr/></div>

            <div class="row">
                <h1>Test Discord Integration/Dice Parser:</h1>
            </div>
            <div class="row">
                <p>Enter a message or dice formula:</p>
                <g:textField name="text" style="margin-left: 10px"/>
            </div>

            <div class="row">
                <g:render template="/roll" model="[source: 'text', target: 'target']"/>
            </div>

    </div>
</div>

</body>
</html>
