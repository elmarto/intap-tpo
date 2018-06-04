import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
  @Input() user = null;

  routeFlags = {
    inDashboard: true
  };

  unfold = {
    sports: false,
    user: false
  };

  SPORTS = [
    {
      title: 'NFL',
      route: 'nfl',
      subscription: 'SOCCER_MOCK',
      icon: 'assets/images/shared/header/icon-nfl.png',
    },
    {
      title: 'SOCCER',
      route: 'soccer',
      subscription: 'SOCCER_LEAGUE',
      icon: 'assets/images/shared/header/icon-soccer.png',
    }
  ];

  // USER_OPTIONS: AppSidenavItem[] = [
  //   new AppSidenavItem('PROFILE', 'assets/global/menu-ico-1profile.svg', 'my-profile'),
  //   new AppSidenavItem('SETTINGS', 'assets/global/menu-ico-6settings.svg', 'settings'),
  //   new AppSidenavItem('LOGOUT', 'assets/global/menu-ico-7logout.svg', null, '', null, 'logout')
  // ];

  constructor(private router: Router) {}

  login(): void {

    this.router.navigate(['/home/login']);
  }

  registration(): void {

    this.router.navigate(['/home/registration']);
  }

  back() {
    // this.location.back();
  }

  onSportChange(sport) {
    // this.router.navigate([`/sports/${this.authService.getAppLoaded().route}/matches`]);
  }

  toggleSidenav() {}


  logout() {
    // this.authService.logout().then(() => this.router.navigate(['/']));
  }

  toggleUnfold(unfoldKey) {
    if (!this.unfold[unfoldKey]) {
      this.unfoldAll();
    }
    this.unfold[unfoldKey] = !this.unfold[unfoldKey];
  }

  unfoldAll() {
    this.unfold.sports = this.unfold.user = false;
  }
}
