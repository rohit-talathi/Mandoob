package edreamz.mandoob.network;

/**
 * Created by Anil Sharma and Swapnil Jadhav on 1/2/16.
 */
public interface IUrls {

//    String BASE_URL = "http://paudgaon.com/zeal_school/";


    String BASE_URL = "http://mulshi.co.in/zeal_school/";

    //Student
    String Login_details = BASE_URL + "student_login.php";
    String get_student_info = BASE_URL + "get_student_info.php?id=";

    String Sent_msg_by_student = BASE_URL + "send_notice_by_user.php";
    String student_inbox = "http://paudgaon.com/zeal_school/get_inbox_for_student.php?reg_no=";
    String Sent_box_student = BASE_URL + "get_send_box_forstudent.php?reg_no=";
    String get_students_attendance = "http://paudgaon.com/zeal_school/get_students_attendance.php?";
    String caption_name_list = "http://paudgaon.com/zeal_school/get_caption_name.php";
    String caption_data = "http://paudgaon.com/zeal_school/get_captions_data.php?caption=";
    String get_result_for_students = BASE_URL + "get_result.php?reg_no=";




    //teacher
    String get_attendance_data = "http://paudgaon.com/zeal_school/attendence_for_class_by_teacher.php?roll_no=";
    String save_attendance_by_teacher = "http://paudgaon.com/zeal_school/save_attendance_by_teacher.php";

    String Add_result_for_student = "http://paudgaon.com/zeal_school/add_result_for_student.php";
    String get_result_for_students_for_updating = BASE_URL + "get_result.php?";


    String update_result_for_student = "http://paudgaon.com/zeal_school/update_result_for_student.php";

    String send_msg_by_teacher = BASE_URL + "send_notice_by_teacher.php";
    String teacher_inbox = "http://paudgaon.com/zeal_school/get_inbox_for_teacher.php?roll_no=";
    String get_sendbox__for_teacher = "http://paudgaon.com/zeal_school/get_sendbox_for_teacher.php?roll_no=";

    String Add_student_health_info = BASE_URL + "add_health_status.php";
    String Update_student_health_info = BASE_URL + "update_health_status.php";
    String get_student_health_info = BASE_URL + "get_health_status?reg_no=";



    //Delete
    //Delete msg list


    //admin


    String Add_student_info = BASE_URL + "add_new_student.php";
    String get_student_info_reg_no = BASE_URL + "get_student_info_reg_no.php?reg_no=";
    String Update_student_info = BASE_URL + "update_student_info.php";
    String Add_teacher_info = BASE_URL + "add_new_teacher.php";
    String get_teacher_info_rollno = BASE_URL + "get_teacher_info_rollno.php?roll_no=";
    String Update_teacher_info = BASE_URL + "update_teacher_info.php";

    String get_Roll_no = "http://paudgaon.com/zeal_school/get_roll_number.php?";
    String get_all_teachers = "http://paudgaon.com/zeal_school/get_teachers_list.php";


    String admin_inbox = "http://paudgaon.com/zeal_school/get_inbox_for_admin.php?admin=" + "Admin";
    String send_msg_by_admin = BASE_URL + "send_notice_by_admin.php";
    String sent_box_admin = "http://paudgaon.com/zeal_school/get_sendbox_for_admin.php?admin=" + "Admin";


    String galary_data_submit = "http://paudgaon.com/zeal_school/galary_data_submit.php";  //photo


    String Add_annual_planner ="http://paudgaon.com/zeal_school/add_annual_planner.php";
    String View_annual_planner= "http://paudgaon.com/zeal_school/get_annual_planner.php";
    String Update_Annual_Planner="http://paudgaon.com/zeal_school/update_annual_planner.php";
    String Add_holiday= "http://paudgaon.com/zeal_school/add_holiday.php";
    String Update_holiday="http://paudgaon.com/zeal_school/update_holiday.php";
    String get_holiday="http://paudgaon.com/zeal_school/get_holiday.php";


    String Add_total_fees="http://paudgaon.com/zeal_school/add_total_fees.php";
    String get_total_fees= "http://paudgaon.com/zeal_school/get_total_fees.php?reg_no=";
    String Update_total_fees="http://paudgaon.com/zeal_school/update_total_fees.php";
    String Added_new_installment = BASE_URL + "add_new_installment_for_student.php";
    String update_all_school_fees = BASE_URL + "update_all_school_fees_dtls.php";
    String get_all_school_fee_details = "http://paudgaon.com/zeal_school/get_school_fees_dtls.php?reg_no=";
    String get_all_transport_fee_details = "http://paudgaon.com/zeal_school/get_transport_fees_dtls.php?reg_no=";

    String change_password="http://paudgaon.com/zeal_school/change_password.php";


}


