package entity.com;
//这个类对应着数据库中的user-table，作用是对user-table表的信息的读取和设置
public class UserTable extends Id {
        private String name;
        private String password;
        private String email;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		@Override
		public String toString() {
			return "UserTable [name=" + name + ", password=" + password + ", email=" + email + ", id=" + id + "]";
		}
        
        
}
