import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  constructor(private adminService:AdminService,private login:LoginService,private r:Router) {
    this.getAllProducts();
   }
  ngOnInit(): void { }
  productForm=new FormGroup({
    'productId':new FormControl(),
    'name':new FormControl(),
    'desc':new FormControl(),
    'price':new FormControl()
  });
  sendProductData(){
    console.log(this.productForm.value);
    this.adminService.addNewProduct(this.productForm.value).subscribe(
      response=>{
        console.log(response);
        this.getAllProducts();
      }) 
   }
  allProducts:any;
  getAllProducts(){
      this.adminService.getAllProducts().subscribe(
        response=>{
          this.allProducts=response;
        })
  }
  deleteProduct(productid:string){
    console.log(productid);
    this.adminService.deleteProduct(productid).subscribe(
      response=>{
        this.getAllProducts();
      })
  }
  editProductForm=new FormGroup({
    'productId':new FormControl(),
    'name':new FormControl(),
    'desc':new FormControl(),
    'price':new FormControl()
  });

  getEditableProduct(product:any){
    console.log(product);
    this.editProductForm.setValue(product);
    this.editProductForm.reset;
  }

  updateProudct(){
    this.adminService.updateProduct(this.editProductForm.value).subscribe(
      response=>{
        this.getAllProducts();
      })
  }
  logout()
  {
    this.login.isLoggedIn1=false;
    this.r.navigate([""]);

  }
  
}

