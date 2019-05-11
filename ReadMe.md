Almost all applications have login fucntionality and when we try to create new project we either copy paste the code from other project and add validation for username/password. I have created this library which will validate the fields using 2-3 lines of code. You juse need to pass the EditText instance of username and password to LoginBuilder class.

Step to add this import library in your project.

Add this in your root build.gradle at the end of repositories:

**step 1**
```

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
```

**Step 2**
```
dependencies {
	        implementation 'com.github.vinayakmestri:validotor:0.1.1'
	}

```


Now lets go coding

Your login.xml file would be like
```
<EditText
        android:id="@+id/username"
        android:layout_width="match_parent"
        android:layout_height="50dp" />

    <EditText
        android:id="@+id/password"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:inputType="textPassword" />

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="onClick"
        android:text="Login" />
```

Add below code in your LoginActivity.java

```

// parameters username and password are the EditText intsance.

 LoginBuilder loginBuilder = LoginBuilder.getInstance().setPasswordField(password).setUsernameField(username)
                .addPasswordValidations(new ValidationBuilder().add(new TextLengthValidator(5,"Short length")).add(new EmptyValidator("Empty password")))
                .addUserNameValidations(new ValidationBuilder().add(new EmailValidator("Wrong email")).add(new EmptyValidator("Empty username"))).build();
        loginAuthBuilder.setCallBack(new ValidationCallBack() {
            @Override
            public void onSuccess(String username, String password) {
                Toast.makeText(A.this,username+ " "+password,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(int id, String errorCode) {

                Toast.makeText(A.this,""+errorCode,Toast.LENGTH_SHORT).show();
            }

        }).login();

```


Thank you...
