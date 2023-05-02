import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';
import { LoginService } from '../services/login.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  constructor(private userService:UserService, private adminService:AdminService ,private login:LoginService,private r:Router) {
    this.getUserDetails();
    this.getAllProducts();
  }

  userDetails:any;
  ngOnInit(): void { }

  getUserDetails(){
    this.userService.getUserDetails().subscribe(
      response=>{
        console.log(response);
        this.userDetails=response;
      } )
  }
  addProductToCart(productObj:any){
    this.userService.addProductToUserCart(productObj).subscribe(
      response=>{
        this.getUserDetails();
      } )    
  }

  allProducts:any;
  getAllProducts(){

   // this.allProducts = this.adminService.getAllProducts();

    this.adminService.getAllProducts().subscribe(
      response=>{
        this.allProducts=response;
      })
  }
  logout()
  {
    this.login.isLoggedIn1=false;
    this.r.navigate([""]);

  }
  
}
