# PxView with the Contentsquare react-native

## Usages

* On the landing page, the Contentsquare SDK should
send a *Login* screen:
Contentsquare.send('Login');

* If you click the button "Don't have an account?" the
Contentsquare SDK should send a *SignUpModal* screen and a
transaction: 
Contentsquare.send('SignUpModal');
Contentsquare.sendTransaction(23.45, Currency.USD);