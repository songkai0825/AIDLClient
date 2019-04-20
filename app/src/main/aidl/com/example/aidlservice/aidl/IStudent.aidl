// IStudent.aidl
package com.example.aidlservice.aidl;

import com.example.aidlservice.aidl.StudtInfo;
// Declare any non-default types here with import statements

interface IStudent {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void addStudentInfoReq(in StudtInfo studtInfo);
}
