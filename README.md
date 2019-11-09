# Lập trình mạng
Dự án môn Lập trình mạng: Trò chơi Cờ caro sử dụng Java Socket theo mô hình CLient-Server.

## Usage:
### Database
> *NOTE:  Schema tên ~~`caro`~~ đã bị loại bỏ, thay vào đó hãy tạo schema tên `mydb` trước khi sử dụng.*

Tạo schema tên `mydb` chứa 2 bảng `user` và `user_infomation`, có thể sử dụng các file chứa trong thư mục `dumps`.

### Khởi chạy phía Server
> *NOTE: Hãy import các file trong thư mục driver vào project phía Server trước khi khởi chạy. Đồng thời sửa lại đường dẫn trong `database.class` phía Server (nếu cần thiết)*.

Khởi chạy `ServerCaro.class`.

### Khởi chạy phía Client
Trong phiên bản hiện tại, trước khi khởi chạy, cần xác định trước IP phía **chủ phòng chơi**. Điền IP vào hàm khởi tạo `CaroClient()` trong `CaroClient.class`. Khởi chạy `ClientCaro.class`.

## Include:
### ServerCaro
Project chạy trên Server
### ClientCaro
Project chạy phía Client
### dumps
Thư mục chứa các file câu lệnh khởi tạo CSDL
### driver
Thư mục chứa driver JDBC `mysql-connector-java-5.1.48-bin.jar`.

### File báo cáo - `report.pdf`
