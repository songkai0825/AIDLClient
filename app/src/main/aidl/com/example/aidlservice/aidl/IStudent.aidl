// IStudent.aidl
package com.example.aidlservice.aidl;

import com.example.aidlservice.aidl.student.StudtInfo;
// Declare any non-default types here with import statements

interface IStudent {

    void addStudentInfoReq(in StudtInfo studtInfo);

}
