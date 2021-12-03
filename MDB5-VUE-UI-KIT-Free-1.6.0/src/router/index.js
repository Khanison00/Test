import { createRouter, createWebHashHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Addemp from '../views/Addemp.vue'
import Showemp from '../views/Showemp.vue'



const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/addemp',
    name: 'Addemp',
    component: Addemp
  },
  {
    path: '/Showemp',
    name: 'Showemp',
    component: Showemp
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
