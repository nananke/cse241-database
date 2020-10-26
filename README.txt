CSE241
Final Project
Like HW4, advlist folder contains final java code for my project, in kex220 folder, it includes Advlist.jar, Advlist.java, ojdbc8.jar, Manifest.txt

Interface Using instruction:
1.Firstly, enter you username and password for security.
2.Once successfully login, I random generate a customer to you. You have 3 options to do(as this random customer). 
 Opt1:deposit or withdraw from saving|checking account. This customer may not have a saving|checking account as you commanded, the system will re-generate another customer that count(saving_account|checking_account) > 0

 Opt2:buying with a debit or credit card.
 Buying with a credit or debit card, as you choice.
 This customer may not have a debit|card account as you commanded, the system will re-generate another customer that count(debit_card|credit_card) > 0
 Also, since a debit card is tied to a checking account(a checking account may do not have a debit card, but a debit card must related to a checking account), when buying with a debit card, money balance will deduct from you checking account balance.
 
 Opt3:open a new account.
 User have option to open a new saving account with %2.2 interest rates, since there are min_balance rule(to open a new saving account, you have to deposit more than 500$, the original running_balance I set for new opened saving account is 500$ )
 For checking account, there is not min_balance rules, the original interest rate is %0.2