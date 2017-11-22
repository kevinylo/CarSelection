package kevin.lo.cardealers.helper;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;


public class LocationPermissionHelper implements ActivityCompat.OnRequestPermissionsResultCallback {

    public interface LocationListener {
        void onLastLocationObtained(Location location);
        void onFailedLocationRequest(Exception e);
        void onLocationDenied();
    }

    private static final int REQUEST_FINE_LOCATION = 1;

    private FusedLocationProviderClient fusedLocationProviderClient;
    private Activity activity;
    private LocationListener locationListener;

    public LocationPermissionHelper(Activity activity) {
        this.activity = activity;
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(activity);
    }

    public void setLocationListener(LocationListener locationListener) {
        this.locationListener = locationListener;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_FINE_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLastLocation();
                } else {
                    locationListener.onLocationDenied();
                }
            }
        }
    }

    @SuppressWarnings("MissingPermission")
    private void getLastLocation() {
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                locationListener.onLastLocationObtained(location);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                locationListener.onFailedLocationRequest(e);
            }
        });
    }

    public void checkPermissionToGetLocation() {
        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getLastLocation();
        } else {
            requestPermissions();
        }
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(activity,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_FINE_LOCATION);
    }

}
