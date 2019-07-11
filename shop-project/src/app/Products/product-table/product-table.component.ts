import {Component, OnInit, ViewChild} from '@angular/core';
import {Product} from '../product';
import {MatTableDataSource} from '@angular/material';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material';
import {ProductsService} from '../products.service';
import {Customer} from '../../Users/customer';

@Component({
  selector: 'app-product-table',
  templateUrl: './product-table.component.html',
  styleUrls: ['./product-table.component.scss']
})
export class ProductTableComponent implements OnInit {

  products: Product[];
  columnsToDisplay = ['id', 'name', 'type', 'count', 'category', 'supplier', 'country', 'edit', 'delete'];
  dataSource: MatTableDataSource<Product>;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private productService: ProductsService) {
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.productService.getAllProducts().subscribe(data => {
      this.products = data;
      this.dataSource = new MatTableDataSource<Product>(this.products);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
