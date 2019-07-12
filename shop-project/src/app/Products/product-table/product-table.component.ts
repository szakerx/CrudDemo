import {Component, OnInit, ViewChild} from '@angular/core';
import {Product} from '../product';
import {MatTableDataSource} from '@angular/material';
import {MatDialog} from '@angular/material/dialog';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material';
import {ProductsService} from '../products.service';
import {EditProductComponent} from '../edit-product/edit-product.component';

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

  // Potrzebne do łączenia komponentów z tabelą danych
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  // Wstrzyknięcie serwisu produktów do pobrania ich z bazy oraz dialogu aby edytować rekordy (jeszcze nie działa)
  constructor(private productService: ProductsService, public dialog: MatDialog) {
  }

  ngOnInit() {
    this.reloadData();
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

  // Funkcja onClick dla buttona edycji
  editButtonClick() {
    console.log('edit');
    const dialogRef = this.dialog.open(EditProductComponent, {
      height: '400px',
      width: '600px',
    });


  }

}
