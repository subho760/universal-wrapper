package com.night.easyunitconverter;

import android.os.Bundle;
import com.getcapacitor.BridgeActivity;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.chaquo.python.PyObject;

public class MainActivity extends BridgeActivity {
    
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Initialize Python runtime engine
        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }
    }

    // Native C++ binding declaration
    public native String stringFromJNI();

    // Invoker helper method to run scripts via Chaquopy backend
    public String callPythonBackend(String moduleName, String functionName, Object... args) {
        Python py = Python.getInstance();
        PyObject module = py.getModule(moduleName);
        return module.callAttr(functionName, args).toString();
    }
}
