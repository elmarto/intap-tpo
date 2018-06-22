import { NgModule } from '@angular/core';
import { MatNativeDateModule, MatSelectModule, MatDialogModule, MatSnackBarModule,
  MatSidenavModule, MatButtonModule, MatIconModule, MatTableModule, MatDatepickerModule,
  MatCheckboxModule, MatInputModule, MatButtonToggleModule, MatCardModule, MatProgressSpinnerModule,
  MatTooltipModule, MatRadioModule, MatGridListModule, MatTabsModule, MatPaginatorModule, MatChipsModule,
  MatSliderModule, MatExpansionModule, MatAutocompleteModule} from '@angular/material';

  const MAT_MODULES = [
    MatAutocompleteModule,
    MatNativeDateModule,
    MatSelectModule,
    MatDialogModule,
    MatSnackBarModule,
    MatSidenavModule,
    MatButtonModule,
    MatIconModule,
    MatTableModule,
    MatDatepickerModule,
    MatCheckboxModule,
    MatInputModule,
    MatButtonToggleModule,
    MatCardModule,
    MatRadioModule,
    MatTooltipModule,
    MatProgressSpinnerModule,
    MatGridListModule,
    MatTableModule,
    MatPaginatorModule,
    MatChipsModule,
    MatSliderModule,
    MatTabsModule,
    MatExpansionModule
  ];

@NgModule({
  imports: MAT_MODULES,
  exports: MAT_MODULES
})
export class MaterialModule { }
