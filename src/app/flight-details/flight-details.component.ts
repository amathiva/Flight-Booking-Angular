import { Component, OnInit } from '@angular/core';
import { ServiceFileService } from '../service-file.service';

@Component({
  selector: 'app-flight-details',
  templateUrl: './flight-details.component.html',
  styleUrls: ['./flight-details.component.css']
})
export class FlightDetailsComponent implements OnInit {
  public booking: Object[];
  constructor(public service: ServiceFileService) { }

  ngOnInit() {
    const source:string ='Bangalore';
    const destination:string ='United States';
    const sort:string = 'duration';
    console.log('enter');
    this.service.getFlights(source,destination,sort).subscribe((data: Object[])=>{
      console.log(data);
      this.booking = data;  
    }) 
  }
}
