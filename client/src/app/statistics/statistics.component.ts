import {Component, OnInit} from '@angular/core';
import {HttpService} from "../service/http/http.service";
import {Archive} from "../data/archive";

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css'],
  providers: [HttpService]
})
export class StatisticsComponent implements OnInit {

  archive: Archive;
  urlPers = 'http://localhost:8090/api/files/statisticPercentOfGrades';
  urlSubj = 'http://localhost:8090/api/files/statisticSubjectGrades';
  public barChartOptions: any = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  //public barChartLabels: string[] = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
  public barChartType = 'bar';
  public barChartLegend = true;


  public doughnutChartLabels: string[] = ['5', '4', '3'];
  public doughnutChartData: number[];
  public doughnutChartType = 'doughnut';


  public barChartData: any[];

  // events
  public chartClicked(e: any): void {
    console.log(e);
  }

  public chartHovered(e: any): void {
    console.log(e);
  }

  constructor(private httpService: HttpService) {
    this.archive = new Archive();
  }

  ngOnInit() {


    this.barChartData = [{data: []}, {data: []}];
    this.doughnutChartData = [0,0,0];
    this.getGroupStat('4383');
    this.getSubStat('Параллельные алгоритмы');
  }

  getGroupStat(value) {
    this.archive.group = value;
    this.archive.subject = null;
    this.httpService.postStat(this.archive, this.urlSubj)
      .map(resp => resp.json())
      .subscribe(data => {
        this.barChartData = [];
        data.forEach(obj => {
          this.barChartData.push({data: [Number(obj.average)], label: obj.subject})
        });
      })
    this.getSubStat(this.archive.subject);
  }

  getSubStat(value) {
    this.archive.subject = value;
    this.httpService.postStat(this.archive, this.urlPers)
      .map(resp => resp.json())
      .subscribe(data => {
        this.doughnutChartData = [];
        data.forEach(obj => {
          this.doughnutChartData.push(Number(obj.percent));
        });
        console.log(this.doughnutChartData);
      })

  }
}
