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
                <h1>Test Discord Integration:</h1>
            </div>

            <div class="row">
                <p>Enter a webhook URL to send the message to:</p>
                <g:textField name="target" style="margin-left: 10px"/>
            </div>

            <div class="row">
                <p>Enter a message or dice formula:</p>
                <g:textField name="text" style="margin-left: 10px"/>
            </div>

            <g:render template="/roll"/>

    </div>
</div>

</body>
</html>
