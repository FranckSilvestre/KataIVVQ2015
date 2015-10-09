<%@ page import="kataivvq.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="user.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${userInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'passwordFirstTry', 'error')} required">
	<label for="passwordFirstTry">
		<g:message code="user.passwordFirstTry.label" default="Password First Try" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="passwordFirstTry" required="" value="${userInstance?.passwordFirstTry}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'passwordConfirm', 'error')} required">
	<label for="passwordConfirm">
		<g:message code="user.passwordConfirm.label" default="Password Confirm" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="passwordConfirm" required="" value="${userInstance?.passwordConfirm}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="user.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${userInstance?.username}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${userInstance?.password}"/>

</div>

