import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Product} from '../product';
import {ProductsService} from '../products.service';

@Component({
  selector: 'app-product-window',
  templateUrl: './product-window.component.html',
  styleUrls: ['./product-window.component.scss']
})
export class ProductWindowComponent implements OnInit {

  private types: string[];
  private categories: string[];
  private suppliers: string[];

  constructor(public dialogRef: MatDialogRef<ProductWindowComponent>,
              @Inject(MAT_DIALOG_DATA) public product: Product,
              private service: ProductsService) {
  }

  cancelClick() {
    this.dialogRef.close();
  }

  ngOnInit(): void {
    this.LoadEnums();
  }

  LoadEnums() {
    this.service.getAllTypes().subscribe(data => {
      this.types = data;
    });
    this.service.getAllCategories().subscribe(data => {
      this.categories = data;
    });
    this.service.getAllSupplierNames().subscribe(data => {
      this.suppliers = data;
    });
  }


  getProductBack(): Product {
    this.product.supplier.id = this.suppliers.indexOf(this.product.supplier.name);

    return this.product;
  }
}
