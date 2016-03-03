package xuechan.parkingapp2;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class ChooseYourParkingLocation extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_your_parking_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //specify the places info for each Marker
        LatLng my_place = new LatLng(-34,154);
        LatLng park_1 = new LatLng(-34.563, 154.879);
        LatLng park_2 = new LatLng(-34.123, 153.987);
        LatLng park_3 = new LatLng(-35.234, 154.873);
        LatLng park_4 = new LatLng(-34.245, 153.678);

        //assign all the markders
        mMap.addMarker(new MarkerOptions().position(my_place).title("You are here!"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(my_place));

        mMap.addMarker(new MarkerOptions().position(park_1).title("Parking Available 1"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(park_1));

        mMap.addMarker(new MarkerOptions().position(park_2).title("Parking Available 2"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(park_2));

        mMap.addMarker(new MarkerOptions().position(park_3).title("Parking Available 3"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(park_3));

        mMap.addMarker(new MarkerOptions().position(park_4).title("Parking Available 4"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(park_4));

        //here insert the actions when click on each parking available to lead to information page
        directMarker ();


    }

    public void directMarker (){
        mMap.setOnMarkerClickListener(
                new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        if(marker.getTitle().equals("Parking Available 1")){
                            Toast.makeText(ChooseYourParkingLocation.this, "Heading to more information for this parking place ...",
                                    Toast.LENGTH_LONG).show();
                            Intent leadToInfoPage01 = new Intent ("xuechan.parkingapp2.ParkingInfo01");
                            startActivity(leadToInfoPage01);

                        }

                        if(marker.getTitle().equals("Parking Available 2")){
                            Toast.makeText(ChooseYourParkingLocation.this,"Heading to more information for this parking place ...",
                                    Toast.LENGTH_LONG).show();
                            Intent leadToInfoPage02 = new Intent ("xuechan.parkingapp2.ParkingInfo02");
                            startActivity(leadToInfoPage02);

                        }

                        if(marker.getTitle().equals("Parking Available 3")){
                            Toast.makeText(ChooseYourParkingLocation.this,"Heading to more information for this parking place ...",
                                    Toast.LENGTH_LONG).show();
                            Intent leadToInfoPage03 = new Intent ("xuechan.parkingapp2.ParkingInfo03");
                            startActivity(leadToInfoPage03);

                        }

                        if(marker.getTitle().equals("Parking Available 4")){
                            Toast.makeText(ChooseYourParkingLocation.this,"Heading to more information for this parking place ...",
                                    Toast.LENGTH_LONG);
                            Intent leadToInfoPage04 = new Intent ("xuechan.parkingapp2.ParkingInfo04");
                            startActivity(leadToInfoPage04);

                        }


                        return true;
                    }
                }
        );

    }
}
