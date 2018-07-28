// we need to add to gradle app the implementation
    implementation 'com.android.support:design:27.1.1'
///////////////////////////////////////////////////////

// 1. Simple notofocation onclick

// create a method
  private void createNotification(int nId, int icon, String title, String msg){
          NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context,"Shimisys")
                  .setSmallIcon(icon)
                  .setContentTitle(title)
                  .setContentText(msg);

          NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
          notificationManager.notify(nId,notificationBuilder.build());
    }
    
// on onclick method i need to put the following code
  createNotification(50,R.drawable.starticon,"this is title","this is the message");



// 2. down notification (i understand) on down of the app

  String message = "Your WIFI disabled please turn it ON";
                  int myDuration = 5000; // to defign the time untile disappear 5 seconde.
                  Snackbar.make(v, message, Snackbar.LENGTH_LONG) // v = onClick view v ; we ovverite the length.
                          .setAction("אוקיי", new View.OnClickListener() { // onClick the text "הבנתי".
                              @Override
                              public void onClick(View v) {
                                  wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE); // for example this command turn the wifi on.
                                  wifiManager.setWifiEnabled(true); 

                                  Toast.makeText(context, "WIFI on", Toast.LENGTH_SHORT).show(); // just a toast

                              }
                          })
                          .setDuration(myDuration) // the duration that we defign 5 secound
                          .setActionTextColor(Color.GREEN) // the text "הבנתי" color.
                          .show();

// 3. Notofication with action.
// onClick we need to call the method 
                createNotificationAction(40,R.drawable.starticon,"ShimiSys - news", "Hello to Shimisys App");
// the method createNotificatinAction:
private void createNotificationAction(int nId, int icon, String title, String msg) {
        // first lets define the intent to trigger when notification is selected.
        Intent intent = new Intent(context,CustomNotifi.class);
        // now we need to turn this intent to pending intent.
        // using pendingIntent getActivity(..).
        int requstId = (int) System.currentTimeMillis();
        int flags = PendingIntent.FLAG_CANCEL_CURRENT; // cancel an old intent to create a new one;
        PendingIntent pendingIntent = PendingIntent.getActivity(context,requstId,intent,flags);

        // now we can attach the pending intent to new notification use set content intent;
        Notification notification = new NotificationCompat.Builder(context,"shimisys")
                .setSmallIcon(icon)
                .setContentTitle(title)
                .setContentText(msg)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.tok,"OK",pendingIntent)
                .addAction(R.drawable.tnok,"NOT",null)
                .build();

        NotificationManager notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(nId,notification);
    }

// for PendingIntent we need to craete new activity
// so i created CustomNoti activity, i dont chage there anything, just build layout 

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical"
    android:layout_margin="16dp">

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/btnScan"
        android:text="Scan wifi"
        android:layout_marginTop="10dp"
        android:textSize="20sp"
        android:background="#4285f4"
        android:textColor="#fff"/>

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/btnStop"
        android:text="Stop"
        android:textSize="20sp"
        android:background="#4285f4"
        android:layout_marginTop="10dp"
        android:textColor="#fff"/>

    <android.support.v4.widget.ContentLoadingProgressBar
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        style="@style/Widget.AppCompat.ProgressBar"
        android:layout_gravity="center"
        android:layout_marginTop="2dp"
        android:id="@+id/proBar"
        />

    <ListView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/lstView"
        android:layout_marginTop="5dp"/>


</LinearLayout>

