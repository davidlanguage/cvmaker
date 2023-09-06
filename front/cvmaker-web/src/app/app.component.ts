import { Component } from '@angular/core';
import { LandingPageMainDescription } from 'src/app/model/LandingPageCenterDescription';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  pageTitle:string = 'cvmaker-web';

  petitionLanguage:string = 'es';

  landingPageInfo: LandingPageMainDescription = {
    title : "Title not provided",
    firstParagraph : `
    Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo
    ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient
    montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
     quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec,
     ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo
    ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient
    montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
     quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec,
    Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo
    ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient
    montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
     quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec,
     ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo
    ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient
    montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
     quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec,
     `,
     secondParagraph: `
     Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo
     ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient
     montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
      quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec,
      ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo
     ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient
     montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
      quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec,
     Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo
     ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient
     montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
      quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec,
      ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo
     ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient
     montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
      quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec,
      `,
  };
  //TODO: add here the logic for title -> Take it from center.components.ts and pass it here
  //BONUS: create a service class to deal with the logic separatelly
  change(){
    this.landingPageInfo.secondParagraph = "asdasdsa";
  }

}
