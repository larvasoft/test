
# MDM Test

Create your own local branch and publish to this repository

Step 1 : 

Create an application which is elevated as device admin which takes permission listed below 
 
1.  SMS (SEND_SMS,RECEIVE_SMS)
2.  Media (MANAGE_EXTERNAL_STORAGE)
3.  Location (ACCESS_BACKGROUND_LOCATION,ACCESS_COARSE_LOCATION,ACCESS_FINE_LOCATION)
4.  Boot Info (RECEIVE_BOOT_COMPLETED)
5.  MANAGE_DEVICE_LOCK_STATE (Bonus Points)
For Reference : https://developer.android.com/reference/android/devicelock/package-summary

Step 2 : 

Open the app in kiosk mode and create function to enable/disable kiosk mode

For Reference : https://stackoverflow.com/questions/56766782/make-my-android-app-to-fully-kiosk-mode-when-enabled

Step 3 : 

Create a external trigger which enable/disable kiosk mode in real time

Use any preferred method for realtime communication
i.e. Firebase , Websockets
