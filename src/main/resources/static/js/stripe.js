const stripe = Stripe('pk_test_51RbM3VCkOtib7mYMgjxaVtuQFRbvpjy1NmNeAqEZoPJL7NzwuWShj0ZNr4GU0Q67ZFjLCXQ24koZXQsMxFCLoIxu00Qk2KL2zR');
const paymentButton = document.querySelector('#paymentButton');

paymentButton.addEventListener('click', () => {
	stripe.redirectToCheckout({
		sessionId: sessionId
	})
});