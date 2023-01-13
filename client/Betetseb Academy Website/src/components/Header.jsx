import React from "react";

const Header = () => {
  return (
    <div className="text-colorPrimarySurface flex items-center justify-between md:text-colorPrimary px-6 py-4">
      {/* Logo */}
      <div className="font-crimson font-bold  text-3xl md">Beteseb Academy</div>
      <nav className="">
        <ul className="hidden md:flex gap-7 text-lg text-colorPrimarySurfaceDark">
          <li>
            <a href="#">Home</a>
          </li>
          <li>
            <a href="#">Gallery</a>
          </li>
          <li>
            <a href="#">Contact Us</a>
          </li>
        </ul>
      </nav>
    </div>
  );
};

export default Header;
