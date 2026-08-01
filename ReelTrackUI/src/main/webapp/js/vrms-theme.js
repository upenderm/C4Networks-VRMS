(function(){
var t=localStorage.getItem('vrms-theme')||'light';
document.documentElement.setAttribute('data-theme', t);
function setTheme(name) {
document.documentElement.setAttribute('data-theme', name);
localStorage.setItem('vrms-theme', name);
document.querySelectorAll('.theme-btn').forEach(function(b){b.classList.remove('active');});
var btn = document.getElementById('theme-'+name);
if(btn)btn.classList.add('active');
}
window.setTheme=setTheme;
document.addEventListener('DOMContentLoaded', function(){
setTheme(localStorage.getItem('vrms-theme')||'light');
});
})();