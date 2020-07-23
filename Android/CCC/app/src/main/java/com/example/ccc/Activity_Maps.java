package com.example.ccc;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesClient;

import java.util.Arrays;
import java.util.List;

/**
 * An activity that displays a map showing the place at the device's current location.
 */
public class Activity_Maps extends AppCompatActivity
        implements OnMapReadyCallback {

    //Localização dos marcadores
    private static final LatLng PontodoCambio = new LatLng(-23.6610184,-46.6950217);
    private Marker mPontodoCambio;

    private static final LatLng Shoptur = new LatLng(-23.6785695,-46.7007849);
    private Marker mShoptur;

    private static final LatLng Cotacao = new LatLng(-23.6310282,-46.7385377);
    private Marker mCotacao;

    private static final LatLng Travelex = new LatLng(-23.676352, -46.677803);
    private Marker mTravelex;

    private static final LatLng Orion = new LatLng(-23.6908763,-46.6251869);
    private Marker mOrion;

    private static final LatLng Cambiar = new LatLng(-23.625516,-46.7044951);
    private Marker mCambiar;

    private static final LatLng Sagitur = new LatLng(-23.6231169,-46.7007961);
    private Marker mSagitur;

    private static final LatLng Treviso = new LatLng(-23.6214215,-46.7016544);
    private Marker mTreviso;

    private static final LatLng Exchange = new LatLng(-23.6317456,-46.7383266);
    private Marker mExchange;

    private static final LatLng GetMoney = new LatLng(-23.5707821,-46.6455785);
    private Marker mGetMoney;

    private static final LatLng PortoTurismo = new LatLng(-23.6074814,-46.659183);
    private Marker mPortoTurismo;

    private static final LatLng Forex = new LatLng(-23.6045241,-46.6727416);
    private Marker mForex;

    private static final LatLng Confidence = new LatLng(-23.590703,-46.6922757);
    private Marker mConfidence;

    private static final LatLng Providence = new LatLng(-23.5912009,-46.8313561);
    private Marker mProvidence;

    private static final LatLng Paulistano = new LatLng(-23.5805639,-46.6864889);
    private Marker mPaulistano;

    private static final LatLng GetMoney2 = new LatLng(-23.6101127,-46.6686944);
    private Marker mGetMoney2;

    private static final LatLng TOP = new LatLng(-23.5655208,-46.6529341);
    private Marker mTOP;

    private static final LatLng PRIMECASH = new LatLng(-23.55488,-46.6382707);
    private Marker mPRIMECASH;

    private static final LatLng Marzo = new LatLng(-23.5343855,-46.6594854);
    private Marker mMarzo;

    private static final String TAG = Activity_Maps.class.getSimpleName();
    private GoogleMap map;
    private CameraPosition cameraPosition;

    // The entry point to the Places API.
    private PlacesClient placesClient;

    // The entry point to the Fused Location Provider.
    private FusedLocationProviderClient fusedLocationProviderClient;

    // A default location (Sydney, Australia) and default zoom to use when location permission is
    // not granted.
    private final LatLng defaultLocation = new LatLng(-33.8523341, 151.2106085);
    private static final int DEFAULT_ZOOM = 15;
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    private boolean locationPermissionGranted;

    // The geographical location where the device is currently located. That is, the last-known
    // location retrieved by the Fused Location Provider.
    private Location lastKnownLocation;

    // Keys for storing activity state.
    // [START maps_current_place_state_keys]
    private static final String KEY_CAMERA_POSITION = "camera_position";
    private static final String KEY_LOCATION = "location";
    // [END maps_current_place_state_keys]

    // Used for selecting the current place.
    private static final int M_MAX_ENTRIES = 5;
    private String[] likelyPlaceNames;
    private String[] likelyPlaceAddresses;
    private List[] likelyPlaceAttributions;
    private LatLng[] likelyPlaceLatLngs;

    // [START maps_current_place_on_create]
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // [START_EXCLUDE silent]
        // [START maps_current_place_on_create_save_instance_state]
        // Retrieve location and camera position from saved instance state.
        if (savedInstanceState != null) {
            lastKnownLocation = savedInstanceState.getParcelable(KEY_LOCATION);
            cameraPosition = savedInstanceState.getParcelable(KEY_CAMERA_POSITION);
        }
        // [END maps_current_place_on_create_save_instance_state]
        // [END_EXCLUDE]

        // Retrieve the content view that renders the map.
        setContentView(R.layout.layout_maps);

        // [START_EXCLUDE silent]
        // Construct a PlacesClient
        Places.initialize(getApplicationContext(), getString(R.string.google_maps_key));
        placesClient = Places.createClient(this);

        // Construct a FusedLocationProviderClient.
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        // Build the map.
        // [START maps_current_place_map_fragment]
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // [END maps_current_place_map_fragment]
        // [END_EXCLUDE]
    }
    // [END maps_current_place_on_create]

    /**
     * Saves the state of the map when the activity is paused.
     */
    // [START maps_current_place_on_save_instance_state]
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (map != null) {
            outState.putParcelable(KEY_CAMERA_POSITION, map.getCameraPosition());
            outState.putParcelable(KEY_LOCATION, lastKnownLocation);
        }
        super.onSaveInstanceState(outState);
    }
    // [END maps_current_place_on_save_instance_state]

    /**
     * Sets up the options menu.
     * @param menu The options menu.
     * @return Boolean.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.current_place_menu, menu);
        return true;
    }

    /**
     * Handles a click on the menu option to get a place.
     * @param item The menu item to handle.
     * @return Boolean.
     */
    // [START maps_current_place_on_options_item_selected]
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.option_get_place) {
            showCurrentPlace();
        }
        return true;
    }
    // [END maps_current_place_on_options_item_selected]

    /**
     * Manipulates the map when it's available.
     * This callback is triggered when the map is ready to be used.
     */
    // [START maps_current_place_on_map_ready]
    @Override
    public void onMapReady(GoogleMap map) {
        this.map = map;


        mPontodoCambio = map.addMarker(new MarkerOptions()
                .position(PontodoCambio)
                .title("Ponto do Câmbio")
                .snippet(""));
        mPontodoCambio.setTag(0);

        mShoptur = map.addMarker(new MarkerOptions()
                .position(Shoptur)
                .title("Shoptur (Casa de Câmbio)")
                .snippet(""));
        mShoptur.setTag(0);

        mCotacao = map.addMarker(new MarkerOptions()
                .position(Cotacao)
                .title("Cotação Câmbio")
                .snippet(""));
        mCotacao.setTag(0);

        mTravelex = map.addMarker(new MarkerOptions()
                .position(Travelex)
                .title("Travelex Confidence - Câmbio")
                .snippet(""));
        mTravelex.setTag(0);

        mOrion = map.addMarker(new MarkerOptions()
                .position(Orion)
                .title("Orion Câmbio - Unidade Daycoval Diadema - Shopping Praça da Moça")
                .snippet(""));
        mOrion.setTag(0);

        mCambiar = map.addMarker(new MarkerOptions()
                .position(Cambiar)
                .title("Cambiar - Online Exchange Search")
                .snippet(""));
        mCambiar.setTag(0);

        mSagitur = map.addMarker(new MarkerOptions()
                .position(Sagitur)
                .title("Sagitur Casa de Câmbio")
                .snippet(""));
        mSagitur.setTag(0);

        mTreviso = map.addMarker(new MarkerOptions()
                .position(Treviso)
                .title("Treviso - Money Exchange")
                .snippet(""));
        mTreviso.setTag(0);

        mExchange = map.addMarker(new MarkerOptions()
                .position(Exchange)
                .title("Cotação Câmbio Exchange")
                .snippet(""));
        mExchange.setTag(0);

        mGetMoney = map.addMarker(new MarkerOptions()
                .position(GetMoney)
                .title("Get Money Exchange Houses")
                .snippet(""));
        mGetMoney.setTag(0);

        mPortoTurismo = map.addMarker(new MarkerOptions()
                .position(PortoTurismo)
                .title("Porto Turismo - Casa de Câmbio")
                .snippet(""));
        mPortoTurismo.setTag(0);

        mForex = map.addMarker(new MarkerOptions()
                .position(Forex)
                .title("Forex Done - Casa de Câmbio")
                .snippet(""));
        mForex.setTag(0);

        mConfidence = map.addMarker(new MarkerOptions()
                .position(Confidence)
                .title("Confidence Câmbio")
                .snippet(""));
        mConfidence.setTag(0);

        mProvidence = map.addMarker(new MarkerOptions()
                .position(Providence)
                .title("Providence Exchange Casa de Câmbio")
                .snippet(""));
        mProvidence.setTag(0);

        mPaulistano = map.addMarker(new MarkerOptions()
                .position(Paulistano)
                .title("Câmbio Paulistano | Casa de Câmbio em São Paul")
                .snippet(""));
        mPaulistano.setTag(0);

        mGetMoney2 = map.addMarker(new MarkerOptions()
                .position(GetMoney2)
                .title("Get Money Exchange Houses - Shopping Ibirapuera")
                .snippet(""));
        mGetMoney2.setTag(0);

        mTOP = map.addMarker(new MarkerOptions()
                .position(TOP)
                .title("Casa de Câmbio TOP DayPay Western Union")
                .snippet(""));
        mTOP.setTag(0);

        mPRIMECASH = map.addMarker(new MarkerOptions()
                .position(PRIMECASH)
                .title("Money Exchange - PRIMECASH")
                .snippet(""));
        mPRIMECASH.setTag(0);

        mMarzo = map.addMarker(new MarkerOptions()
                .position(Marzo)
                .title("Casa de Câmbio Marzo Exchange")
                .snippet(""));
        mMarzo.setTag(0);


        // [START_EXCLUDE]
        // [START map_current_place_set_info_window_adapter]
        // Use a custom info window adapter to handle multiple lines of text in the
        // info window contents.
        this.map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            // Return null here, so that getInfoContents() is called next.
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                // Inflate the layouts for the info window, title and snippet.
                View infoWindow = getLayoutInflater().inflate(R.layout.custom_info_contents,
                        (FrameLayout) findViewById(R.id.map), false);

                TextView title = infoWindow.findViewById(R.id.title);
                title.setText(marker.getTitle());

                TextView snippet = infoWindow.findViewById(R.id.snippet);
                snippet.setText(marker.getSnippet());

                return infoWindow;
            }
        });
        // [END map_current_place_set_info_window_adapter]

        // Prompt the user for permission.
        getLocationPermission();
        // [END_EXCLUDE]

        // Turn on the My Location layer and the related control on the map.
        updateLocationUI();

        // Get the current location of the device and set the position of the map.
        getDeviceLocation();
    }
    // [END maps_current_place_on_map_ready]

    /**
     * Gets the current location of the device, and positions the map's camera.
     */
    // [START maps_current_place_get_device_location]
    private void getDeviceLocation() {
        /*
         * Get the best and most recent location of the device, which may be null in rare
         * cases when a location is not available.
         */
        try {
            if (locationPermissionGranted) {
                Task<Location> locationResult = fusedLocationProviderClient.getLastLocation();
                locationResult.addOnCompleteListener(this, new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        if (task.isSuccessful()) {
                            // Set the map's camera position to the current location of the device.
                            lastKnownLocation = task.getResult();
                            if (lastKnownLocation != null) {
                                map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                                        new LatLng(lastKnownLocation.getLatitude(),
                                                lastKnownLocation.getLongitude()), DEFAULT_ZOOM));
                            }
                        } else {
                            Log.d(TAG, "Current location is null. Using defaults.");
                            Log.e(TAG, "Exception: %s", task.getException());
                            map.moveCamera(CameraUpdateFactory
                                    .newLatLngZoom(defaultLocation, DEFAULT_ZOOM));
                            map.getUiSettings().setMyLocationButtonEnabled(false);
                        }
                    }
                });
            }
        } catch (SecurityException e)  {
            Log.e("Exception: %s", e.getMessage(), e);
        }
    }
    // [END maps_current_place_get_device_location]

    /**
     * Prompts the user for permission to use the device location.
     */
    // [START maps_current_place_location_permission]
    private void getLocationPermission() {
        /*
         * Request location permission, so that we can get the location of the
         * device. The result of the permission request is handled by a callback,
         * onRequestPermissionsResult.
         */
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            locationPermissionGranted = true;
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }
    // [END maps_current_place_location_permission]

    /**
     * Handles the result of the request for location permissions.
     */
    // [START maps_current_place_on_request_permissions_result]
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        locationPermissionGranted = false;
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    locationPermissionGranted = true;
                }
            }
        }
        updateLocationUI();
    }
    // [END maps_current_place_on_request_permissions_result]

    /**
     * Prompts the user to select the current place from a list of likely places, and shows the
     * current place on the map - provided the user has granted location permission.
     */
    // [START maps_current_place_show_current_place]
    private void showCurrentPlace() {
        if (map == null) {
            return;
        }

        if (locationPermissionGranted) {
            // Use fields to define the data types to return.
            List<Place.Field> placeFields = Arrays.asList(Place.Field.NAME, Place.Field.ADDRESS,
                    Place.Field.LAT_LNG);

            // Use the builder to create a FindCurrentPlaceRequest.
            FindCurrentPlaceRequest request =
                    FindCurrentPlaceRequest.newInstance(placeFields);

            // Get the likely places - that is, the businesses and other points of interest that
            // are the best match for the device's current location.
            @SuppressWarnings("MissingPermission") final
            Task<FindCurrentPlaceResponse> placeResult =
                    placesClient.findCurrentPlace(request);
            placeResult.addOnCompleteListener (new OnCompleteListener<FindCurrentPlaceResponse>() {
                @Override
                public void onComplete(@NonNull Task<FindCurrentPlaceResponse> task) {
                    if (task.isSuccessful() && task.getResult() != null) {
                        FindCurrentPlaceResponse likelyPlaces = task.getResult();

                        // Set the count, handling cases where less than 5 entries are returned.
                        int count;
                        if (likelyPlaces.getPlaceLikelihoods().size() < M_MAX_ENTRIES) {
                            count = likelyPlaces.getPlaceLikelihoods().size();
                        } else {
                            count = M_MAX_ENTRIES;
                        }

                        int i = 0;
                        likelyPlaceNames = new String[count];
                        likelyPlaceAddresses = new String[count];
                        likelyPlaceAttributions = new List[count];
                        likelyPlaceLatLngs = new LatLng[count];

                        for (PlaceLikelihood placeLikelihood : likelyPlaces.getPlaceLikelihoods()) {
                            // Build a list of likely places to show the user.
                            likelyPlaceNames[i] = placeLikelihood.getPlace().getName();
                            likelyPlaceAddresses[i] = placeLikelihood.getPlace().getAddress();
                            likelyPlaceAttributions[i] = placeLikelihood.getPlace()
                                    .getAttributions();
                            likelyPlaceLatLngs[i] = placeLikelihood.getPlace().getLatLng();

                            i++;
                            if (i > (count - 1)) {
                                break;
                            }
                        }

                        // Show a dialog offering the user the list of likely places, and add a
                        // marker at the selected place.
                        Activity_Maps.this.openPlacesDialog();
                    }
                    else {
                        Log.e(TAG, "Exception: %s", task.getException());
                    }
                }
            });
        } else {
            // The user has not granted permission.
            Log.i(TAG, "The user did not grant location permission.");

            // Add a default marker, because the user hasn't selected a place.
            map.addMarker(new MarkerOptions()
                    .title(getString(R.string.default_info_title))
                    .position(defaultLocation)
                    .snippet(getString(R.string.default_info_snippet)));

            // Prompt the user for permission.
            getLocationPermission();
        }
    }
    // [END maps_current_place_show_current_place]

    /**
     * Displays a form allowing the user to select a place from a list of likely places.
     */
    // [START maps_current_place_open_places_dialog]
    private void openPlacesDialog() {
        // Ask the user to choose the place where they are now.
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // The "which" argument contains the position of the selected item.
                LatLng markerLatLng = likelyPlaceLatLngs[which];
                String markerSnippet = likelyPlaceAddresses[which];
                if (likelyPlaceAttributions[which] != null) {
                    markerSnippet = markerSnippet + "\n" + likelyPlaceAttributions[which];
                }

                // Add a marker for the selected place, with an info window
                // showing information about that place.
                map.addMarker(new MarkerOptions()
                        .title(likelyPlaceNames[which])
                        .position(markerLatLng)
                        .snippet(markerSnippet));

                // Position the map's camera at the location of the marker.
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(markerLatLng,
                        DEFAULT_ZOOM));
            }
        };

        // Display the dialog.
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(R.string.pick_place)
                .setItems(likelyPlaceNames, listener)
                .show();
    }
    // [END maps_current_place_open_places_dialog]

    /**
     * Updates the map's UI settings based on whether the user has granted location permission.
     */
    // [START maps_current_place_update_location_ui]
    private void updateLocationUI() {
        if (map == null) {
            return;
        }
        try {
            if (locationPermissionGranted) {
                map.setMyLocationEnabled(true);
                map.getUiSettings().setMyLocationButtonEnabled(true);
            } else {
                map.setMyLocationEnabled(false);
                map.getUiSettings().setMyLocationButtonEnabled(false);
                lastKnownLocation = null;
                getLocationPermission();
            }
        } catch (SecurityException e)  {
            Log.e("Exception: %s", e.getMessage());
        }
    }
    // [END maps_current_place_update_location_ui]
}