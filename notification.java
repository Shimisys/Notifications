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
