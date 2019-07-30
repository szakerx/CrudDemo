import {Component, OnInit, ViewChild} from '@angular/core';
import {Product} from '../product';
import {MatTableDataSource} from '@angular/material';
import {MatDialog} from '@angular/material/dialog';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material';
import {ProductsService} from '../products.service';
import {AuthService} from '../../Guards/auth.service';
import {ProductWindowComponent} from '../product-window/product-window.component';
import {ConfirmDialogComponent} from '../../confirm-dialog/confirm-dialog.component';
import {ProductFilter} from '../product-filter';
import {Supplier} from '../../Suppliers/Supplier';
import {SupplierService} from '../../Suppliers/supplier.service';

@Component({
  selector: 'app-product-table',
  templateUrl: './product-table.component.html',
  styleUrls: ['./product-table.component.scss']
})
export class ProductTableComponent implements OnInit {

  // Lista produktów
  products: Product[];
  // Lista kolumn które ma wyświetlić mat-table
  columnsToDisplay = ['id', 'name', 'type', 'count', 'category', 'supplier', 'country', 'edit', 'delete'];
  // źródło danych mat-table
  dataSource: MatTableDataSource<Product>;
  filter: ProductFilter = new ProductFilter();

  // Potrzebne do łączenia komponentów z tabelą danych
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  suppliers: Supplier[];
  countries: string[];
  types: string[];
  categories: string[];

  // Wstrzyknięcie serwisu produktów do pobrania ich z bazy oraz dialogu aby edytować rekordy (jeszcze nie działa)
  constructor(public productService: ProductsService, public dialog: MatDialog,
              public authService: AuthService, public supplierService: SupplierService) {
  }

  ngOnInit() {
    this.reloadData();
    this.loadSelects();
  }

  // Wczytanie rekordów z bazy i aktualizacja paginatora oraz filtra
  reloadData() {
    this.productService.getAllProducts().subscribe(data => {
      this.products = data;
      this.dataSource = new MatTableDataSource<Product>(this.products);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  // Filtrowanie mat-table
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  editButtonClick(index: number) {
    const dialogRef = this.dialog.open(ProductWindowComponent, {
      width: '800px',
      data: this.products[index]
    });

    dialogRef.afterClosed().subscribe(product => {
      if (product) {
        this.productService.updateProduct(product).subscribe(data => {
          this.reloadData();
        });
      }
    });
  }

  addButtonClick() {
    const dialogRef = this.dialog.open(ProductWindowComponent, {
      width: '800px',
      data: new Product()
    });

    dialogRef.afterClosed().subscribe(product => {
      if (product) {
        product.id = -1;
        this.productService.addProduct(product).subscribe(data => {
          console.log(data);
          this.reloadData();
        });
      }
    });
  }

  deleteButtonClick(index: number) {
    const dialogConfirm = this.dialog.open(ConfirmDialogComponent, {
      width: '300px',
      data: this.products[index].name
    });

    dialogConfirm.afterClosed().subscribe(confirm => {
      if (confirm) {
        this.productService.deleteProduct(this.products[index]).subscribe(info => {
          console.log(info);
          this.reloadData();
        });
      }
    });
  }

  loadSelects() {
    this.supplierService.getAllSuppliers().subscribe(data => {
      this.suppliers = data;
    });

    this.productService.getCountries().subscribe(data => {
      this.countries = data;
    });

    this.productService.getAllTypes().subscribe(data => {
      this.types = data;
    });

    this.productService.getAllCategories().subscribe(data => {
      this.categories = data;
    });
  }

  doFilter() {
    this.productService.filterProducts(this.filter).subscribe(data => {
      this.products = data;
      this.dataSource = new MatTableDataSource<Product>(this.products);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }
}
