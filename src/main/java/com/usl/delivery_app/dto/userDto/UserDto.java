package com.usl.delivery_app.dto.userDto;

import com.usl.delivery_app.data.OrderData.Order;
import com.usl.delivery_app.data.Usersdata.Users;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date createdOn;
    private boolean emailVerified;
   private List<Order> orders;


    public UserDto(Users user) {
          this.id = user.getId();
          this.firstName = user.getFirstName();
          this.lastName = user.getLastName();
          this.email = user.getEmail();
          this.createdOn = user.getCreatedOn();
          this.emailVerified = user.isEmailVerified();
            this.orders = user.getOrders().stream().map(Order::new).collect(Collectors.toList());
    }
}
