<%--
  Created by IntelliJ IDEA.
  User: ShouYou
  Date: 24/08/2021
  Time: 12:07 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        .text-align-center {
            text-align: center;
        }

        .width-100 {
            width: 100%;
        }

        .width-30 {
            width: 390px;
            margin-right: 10px;
        }

        .width-50 {
            width: 50%;
            margin-right: 10px;
        }
        .text-align-left{
            text-align: left;
        }
    </style>
</head>
<body>
<form:form modelAttribute="medical" action="/medical/create" method="post">
    <div>
        <h3 class="text-align-center">TỜ KHAI Y TẾ</h3>
        <h4 class="text-align-center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC
            KHI CẦN THIẾT</h4>
        <h5 style="color: red" class="text-align-center">Khuyến cáo: Khai báo thông tin sai phạm là vi phạm pháp luật
            Việt Nam và có thể xử lý hình sự</h5>
        <h4>Họ tên(ghi chữ IN HOA)</h4>
        <form:input cssClass="width-100" path="name"/>
        <table>
            <tr>
                <th class="text-align-left">Năm sinh</th>
                <th class="text-align-left">Giới tính</th>
                <th class="text-align-left">Quốc tịch</th>
            </tr>
            <tr>
                <td><form:input cssClass="width-30" path="dateOfBirth"/></td>
                <td><form:select cssClass="width-30" path="gender" items="${gender}"/></td>
                <td><form:input cssClass="width-30" path="country"/></td>
            </tr>
        </table>
        <h4>Số CMND Của Công Dân hoặc số hộ chiếu</h4>
        <form:input cssClass="width-100" path="idCard"/>
        <h4>Thông tin đi lại</h4>
        <form:radiobutton path="informationTransfer" value="Tàu thuyền" label="Tàu thuyền"/>
        <form:radiobutton path="informationTransfer" value="Tàu bay" label="Tàu bay"/>
        <form:radiobutton path="informationTransfer" value="Ô tô" label="Ô tô"/>
        <form:radiobutton path="informationTransfer" label="Khác" id="boxModel"/>
        <table style="margin-left: auto; margin-right: auto">
            <tr>
                <th class="text-align-left">Số hiệu phương tiện</th>
                <th class="text-align-left">Số ghế</th>
            </tr>
            <tr>
                <td><input class="width-100" type="text" placeholder="VD: VN123"></td>
                <td><input class="width-100" type="number"></td>
            </tr>
            <tr>
                <th>Ngày khởi hành</th>
                <th>Ngày kết thúc</th>
            </tr>
            <tr>
                <td class="width-50">
                    <input type="number">
                    <input type="number">
                    <input type="number">
                </td>
                <td class="width-50">
                    <input type="number">
                    <input type="number">
                    <input type="number">
                </td>
            </tr>
        </table>
        <h4>Trong vòng 14 ngày qua anh chị có đến tỉnh thành phố nào không?</h4>
        <form:textarea rows="3" cssClass="width-100" path="countryStay"/>
        <h4>Địa chỉ liên lạc</h4>
        <form:input cssClass="width-100" path="addressContact"/>
        <h4>Địa chỉ nơi ở</h4>
        <form:input cssClass="width-100" path="addressStay"/>
        <table style="width: 1200px">
            <tr>
                <th class="text-align-left">Điện thoại</th>
                <th class="text-align-left">Email</th>
            </tr>
            <tr>
                <td><form:input cssClass="width-100" path="phone"/></td>
                <td><form:input cssClass="width-100" path="email"/></td>
            </tr>
        </table>
        <h4>Trong vòng 14 ngày qua, anh chị có xuất hiện dấu hiệu nào ở dưới đây không</h4>
        <table  border="1" style="border-collapse: collapse">
            <tr style="background-color: lightgray">
                <th width="400px">Triệu chứng</th>
                <th width="100px">Có</th>
                <th width="100px">Không</th>
                <th width="400px">Triệu chứng</th>
                <th width="100px">Có</th>
                <th width="100px">Không</th>
            </tr>
            <tr>
                <td>Sốt</td>
                <td><form:radiobutton path="sot" value="yes"/></td>
                <td><form:radiobutton path="sot" value="no"/></td>
                <td>Nôn/Buồn Nôn</td>
                <td><form:radiobutton path="non_buon_non" value="yes"/></td>
                <td><form:radiobutton path="non_buon_non" value="no" /></td>
            </tr>
            <tr>
                <td>Ho</td>
                <td><form:radiobutton path="ho" value="yes"/></td>
                <td><form:radiobutton path="ho" value="no"/></td>
                <td>Tiêu chảy</td>
                <td><form:radiobutton path="tieu_chay" value="yes"/></td>
                <td><form:radiobutton path="tieu_chay" value="no" /></td>
            </tr>
            <tr>
                <td>Khó thở</td>
                <td><form:radiobutton path="kho_tho" value="yes"/></td>
                <td><form:radiobutton path="kho_tho" value="no"/></td>
                <td>Xuất huyết ngoài da</td>
                <td><form:radiobutton path="xuat_huyet_ngoai_da" value="yes"/></td>
                <td><form:radiobutton path="xuat_huyet_ngoai_da" value="no" /></td>
            </tr>
            <tr>
                <td>Đau họng</td>
                <td><form:radiobutton path="dau_hong" value="yes"/></td>
                <td><form:radiobutton path="dau_hong" value="no"/></td>
                <td>Nổi ban ngoài da</td>
                <td><form:radiobutton path="noi_ban" value="yes"/></td>
                <td><form:radiobutton path="noi_ban" value="no" /></td>
            </tr>
        </table>
        <h4 style="margin-bottom: 0px">Lịch sử phơi nhiễm trong 14 ngày qua, anh chị có</h4>
        <table border="1" style="border-collapse: collapse">
            <tr style="background-color: lightgray">
                <th width="1000px"></th>
                <th width="100px">Có</th>
                <th width="100px">Không</th>
            </tr>
            <tr>
                <td>Đến trang trại chăn nuôi/ chợ buôn bán động vật sống/ cơ sở giết mổ động vật/ tiếp xúc động vật</td>
                <td><form:radiobutton path="den_trang_trai" value="yes"/></td>
                <td><form:radiobutton path="den_trang_trai" value="no"/></td>
            </tr>
            <tr>
                <td>Tiếp xúc gần với bệnh nhân nCov dưới 2m</td>
                <td><form:radiobutton path="tiep_xuc_gan" value="yes"/></td>
                <td><form:radiobutton path="tiep_xuc_gan" value="no"/></td>
            </tr>
        </table>
        <h4 style="color: red">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch, thuộc quản lý của Ban Chỉ đạo phòng chống dịch</h4>
        <input style="margin: auto; background-color: greenyellow" type="submit" value="Gửi tờ khai">
    </div>
</form:form>
</body>
</html>
