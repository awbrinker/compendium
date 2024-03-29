

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'compendium.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'compendium.UserRole'
grails.plugin.springsecurity.authority.className = 'compendium.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               	access: ['permitAll']],
	[pattern: '/error',          	access: ['permitAll']],
	[pattern: '/index',          	access: ['permitAll']],
	[pattern: '/index.gsp',      	access: ['permitAll']],
	[pattern: '/shutdown',       	access: ['permitAll']],
	[pattern: '/logout/**',   	 	access: ['permitAll']],
	[pattern: '/downloads/**', 		access: ['ROLE_USER', 'ROLE_ADMIN']],
	[pattern: '/compendium/**', 	access: ['ROLE_USER', 'ROLE_ADMIN']],
	[pattern: '/user/**', 			access: ['ROLE_USER', 'ROLE_ADMIN']],
	[pattern: '/content/**', 		access: ['ROLE_USER', 'ROLE_ADMIN']],
	[pattern: '/assets/**',      	access: ['permitAll']],
	[pattern: '/**/js/**',       	access: ['permitAll']],
	[pattern: '/**/css/**',      	access: ['permitAll']],
	[pattern: '/**/images/**',   	access: ['permitAll']],
	[pattern: '/**/favicon.ico', 	access: ['permitAll']],
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

grails.plugin.springsecurity.logout.postOnly = false;
grails.databinding.convertEmptyStringsToNull = false