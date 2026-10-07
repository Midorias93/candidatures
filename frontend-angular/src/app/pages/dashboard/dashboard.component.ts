import { Component } from '@angular/core';
import { StatCardComponent } from '../../components/stat-card/stat-card.component';

@Component({
  selector: 'app-dashboard',
  imports: [StatCardComponent],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css',
})
export class DashboardComponent {}
