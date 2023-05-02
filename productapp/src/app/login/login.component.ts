import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { reg } from '../reg';
import { LoginService } from '../services/login.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 constructor( private log:LoginService,private userService:UserService, private router:Router) { }
  ngOnInit(): void {  } 
  loginForm = new FormGroup({
    'emailId':new FormControl(),
    'password':new FormControl()
  });  
  responseData:any;
  sendLoginData(){
    console.log(this.loginForm.value);
    this.userService.loginCheck(this.loginForm.value).subscribe(
      response=>{
          console.log(response);
          this.responseData=response;
          console.log(this.responseData.token);
          console.log(this.responseData.role);
          console.log(this.responseData.message);
          localStorage.setItem("jwt",this.responseData.token);
          localStorage.setItem("role",this.responseData.role);
          // if role is ADMIN : navigate to adminDashboardview
          // (else) if role is USER : navigate to userDashboardview
          if(this.responseData.role=='ROLE_ADMIN'){
            // navigate to AdminDashboardComponent
            this.router.navigateByUrl("/adminView")
            this.log.isLoggedIn1=true;
            alert("login successful")
          }
          else{
            this.router.navigateByUrl("/userView")
            this.log.isLoggedIn1=true;
            alert("login successful")
          }    
      },
      error => {
        console.log("Login error ");
        console.log(error);
        window.alert("Invalid Credentials Entered. Please Try Again");
        location.reload();
        return;
      }
      )
  
  }
}

