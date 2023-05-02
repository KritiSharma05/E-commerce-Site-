import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup,Validators,AbstractControl } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService:UserService) { }

  ngOnInit(): void {
  }
// signup data : userName, emailId, password, mobileNo, address
  signupForm = new FormGroup({
    emailId:new FormControl('',[Validators.required,customValid1]),
    userName:new FormControl('',[Validators.required,Validators.minLength(3),Validators.maxLength(20)]),
    password:new FormControl('',[Validators.required,Validators.minLength(3),Validators.maxLength(20)]),
    mobileNo:new FormControl('',[Validators.required]),
    address:new FormControl('',[Validators.required])   
  });

  sendSignupData(){
    console.log(this.signupForm.value);
    this.userService.registerUser(this.signupForm.value).subscribe(
      response=>{
        console.log(response);
        // alert, snackbar
        alert("sign up successful")        
      }
    
    )
  }
  
  
}
export function customValid1(control:AbstractControl)
{
  if(control.value&&control.value.match("^[a-zA-Z0-9.!#$%&'+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)$"))
  {
    return null;
  }
  else{
    return { myError1:false}
  }

}