/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,js,jsx}"],
  theme: {
    fontFamily: {
      crimson: "'Crimson Pro', serif;"
    },
    colors: {
      'colorPrimary': '#343B5E',
      'colorPrimarySurface': "#FFFFFF",
      'colorPrimarySurfaceDark': "#131313",
      'colorPrimaryDark': '#9CA9F1'
    },
    extend: {
      backgroundImage: {
        'image_home': "url('./src/assets/image_home.jpg')"
      }
    },
  },
  plugins: [],
}
